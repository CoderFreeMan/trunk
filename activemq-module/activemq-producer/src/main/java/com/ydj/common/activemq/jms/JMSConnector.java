package com.ydj.common.activemq.jms;

import com.ydj.common.activemq.adapter.JMSConnectorEvent;
import com.ydj.common.activemq.adapter.JMSConnectorListener;
import com.ydj.common.activemq.adapter.JMSConnectorListenerAdapter;
import org.apache.activemq.ScheduledMessage;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.ProducerCallback;

import javax.jms.*;
import java.io.Serializable;
import java.lang.IllegalStateException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p> Date             :2018/9/22 </p>
 * <p> Module           : </p>
 * <p> Description      : </p>
 * <p> Remark           : </p>
 *
 * @author yangdejun
 * @version 1.0
 * <p>--------------------------------------------------------------</p>
 * <p>修改历史</p>
 * <p>    序号    日期    修改人    修改原因    </p>
 * <p>    1                                     </p>
 */
public class JMSConnector implements InitializingBean, DisposableBean {

    /**
     * log
     */
    private static final Logger logger = LoggerFactory.getLogger(JMSConnector.class);

    private int batchSize = 1000;

    private long intervalTimeInMillisOfCommit = 1000L;

    private int bufferSize = -1;

    private String threadName = "JMSConnector";

    private JmsTemplate jmsTemplate;

    private String destinationQueueName;

    private ActiveMQQueue destinationQueue;

    private LinkedBlockingQueue innerQueue;

    private Thread workerThread;

    private JMSConnectorListener jmsConnectorListener = new JMSConnectorListenerAdapter();

    private static final int CREATED = 0;

    private static final int RUNNING = 1;

    private static final int STOPPING = 2;

    private static final int STOPPED = 3;

    private final AtomicInteger status = new AtomicInteger(CREATED);

    private CountDownLatch latch = new CountDownLatch(1);

    public void send(final Serializable message) {
        jmsConnectorListener.beforeSend(new JMSConnectorEvent(threadName, JMSConnectorEvent.Type.SEND, message));
        doSend(message);
        jmsConnectorListener.afterSend(new JMSConnectorEvent(threadName, JMSConnectorEvent.Type.SEND, message));
    }

    public void doSend(final Serializable message) {
        ensureWork();
        try {
            innerQueue.put(message);
        } catch (InterruptedException e) {
            logger.info(e.getMessage());
            status.set(STOPPING);
        }
    }

    public void delaySend(final Serializable message, final int delaySendTimeInMillis) {
        jmsConnectorListener.beforeSend(new JMSConnectorEvent(threadName, JMSConnectorEvent.Type.DELAY_SEND, message));
        doDelaySend(message, delaySendTimeInMillis);
        jmsConnectorListener.afterSend(new JMSConnectorEvent(threadName, JMSConnectorEvent.Type.DELAY_SEND, message));
    }

    public void doDelaySend(Serializable message, int delaySendTimeInMillis) {
        ensureWork();
        try {
            innerQueue.put(new DelayMessageWrapper(message, delaySendTimeInMillis));
        } catch (InterruptedException e) {
            logger.info(e.getMessage());
            status.set(STOPPING);
        }
    }

    public void ensureWork() {
        if (status.get() > RUNNING) {
            throw new IllegalStateException("JMSConnector is stopping");
        }
        if (status.get() == RUNNING) {
            return;
        } else if (status.get() == CREATED) {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        argumentChecker();
        workerThread = new Thread(null, () -> {
//            @Override
//            public void run() {
                while (status.get() == RUNNING || (status.get() == STOPPED && innerQueue.size() > 0)) {
                    long startTime = System.currentTimeMillis();
                    long currentTime = System.currentTimeMillis();
                    int batchCountt = 0;
                    final List<Serializable> buffer = new ArrayList<>();
                    while (batchCountt < batchSize && (currentTime - startTime < intervalTimeInMillisOfCommit)) {
                        Serializable msg;
                        try {
                            msg = (Serializable) innerQueue.poll(1, TimeUnit.SECONDS);
                        } catch (InterruptedException e) {
                            logger.info("JMS Send Thread Handler is interrupted");
                            status.compareAndSet(RUNNING, STOPPING);
                            break;
                        }
                        if (msg == null) {
                            currentTime = System.currentTimeMillis();
                            continue;
                        }
                        buffer.add(msg);
                        batchCountt++;
                        currentTime = System.currentTimeMillis();
                    }
                    if (buffer.size() == 0) {
                        continue;
                    }
                    try {
                        sendInternal(buffer);
                    } catch (JMSException e) {
                        try {
                            sendInternal(buffer);
                        } catch (JMSException e1) {

                        }
                    }
                }
//            }
        }, threadName);
        workerThread.start();
        status.compareAndSet(CREATED, RUNNING);
        latch.countDown();
        this.jmsConnectorListener.setJMSConnector(this);
        logger.info("{} is started", threadName);
    }

    private void sendInternal(final List<Serializable> buffer) throws JMSException {
            jmsTemplate.execute(destinationQueueName, (Session session, MessageProducer producer)  -> {
//                @Override
//                public Void doInJms(Session session, MessageProducer producer) throws JMSException {
                    for (Serializable item : buffer) {
                        try {
                            if (item instanceof DelayMessageWrapper) {
                                DelayMessageWrapper delayMessageWrapper = (DelayMessageWrapper) item;
                                Serializable messageBody = delayMessageWrapper.messageBody;
                                Message message;
                                if (messageBody instanceof String) {
                                    message = session.createTextMessage(String.valueOf(messageBody));
                                } else {
                                    message = session.createObjectMessage(messageBody);
                                    // TODO 对象传输
                                    ((ObjectMessage) message).setObject(messageBody);
                                }
                                message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, delayMessageWrapper.delaySendTimeInMillis);
                                producer.send(message);
                            } else {
                                Message message;
                                if (item instanceof String) {
                                    message = session.createTextMessage(String.valueOf(item).intern());
                                } else {
                                    message = session.createObjectMessage(item);
                                }
                                producer.send(message);
                            }
                        } catch (JMSException e) {
                            logger.error("Executing Error", e);
                            logger.error("Uncommitted message in buffer , size : {} , approximate left : {} , retry later");
                            throw e;
                        }
                    }
                    if (buffer.size() > 0) {
                        try {
                            session.commit();
                            logger.info("buffer committed : {} , approximate left : {}");
                            jmsConnectorListener.afterCommit(new JMSConnectorEvent(threadName, JMSConnectorEvent.Type.COMMIT, buffer.size()));
                        } catch (JMSException e) {
                            logger.error("commit error");
                            throw e;
                        }
                    }
                    return null;
//                }
            });
    }

    @Override
    public void destroy() throws Exception {
        status.compareAndSet(RUNNING, STOPPING);
        workerThread.join();
        status.compareAndSet(STOPPING, STOPPED);
        jmsConnectorListener.setJMSConnector(null);
    }

    private void argumentChecker() throws Exception {
        if (null == jmsTemplate) {
            throw new IllegalArgumentException("jmsTemplate must be not null");
        }
        if (StringUtils.isBlank(destinationQueueName)) {
            throw new IllegalArgumentException("destinationQueueName must be not null");
        }
        if (!jmsTemplate.isSessionTransacted()) {
            throw new IllegalArgumentException("jmsTemplate must be sessionTransacted when transactional enable");
        }
        if (batchSize < 0) {
            throw new IllegalArgumentException("batchSize must be greater than 0");
        }
        if (intervalTimeInMillisOfCommit < 0L) {
            throw new IllegalArgumentException("intervalTimeInMillisOfCommit must be greater than 0");
        }
        if (bufferSize < 0) {
            innerQueue = new LinkedBlockingQueue();
        } else {
            innerQueue = new LinkedBlockingQueue(bufferSize);
        }
    }

    public void setBatchSize(int batchSize) {
        this.batchSize = batchSize;
    }

    public void setIntervalTimeInMillisOfCommit(long intervalTimeInMillisOfCommit) {
        this.intervalTimeInMillisOfCommit = intervalTimeInMillisOfCommit;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void setDestinationQueueName(String destinationQueueName) {
        this.destinationQueueName = destinationQueueName;
        this.destinationQueue = new ActiveMQQueue(destinationQueueName);
    }

    public void setBufferSize(int bufferSize) {
        this.bufferSize = bufferSize;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public void setJmsConnectorListener(JMSConnectorListener jmsConnectorListener) {
        this.jmsConnectorListener = jmsConnectorListener;
    }

    private static class DelayMessageWrapper implements Serializable {
        final Serializable messageBody;

        final int delaySendTimeInMillis;

        public DelayMessageWrapper(Serializable messageBody, int delaySendTimeInMillis) {
            this.messageBody = messageBody;
            this.delaySendTimeInMillis = delaySendTimeInMillis;
        }
    }

}
