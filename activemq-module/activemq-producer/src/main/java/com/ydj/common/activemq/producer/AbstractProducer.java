package com.ydj.common.activemq.producer;

import com.ydj.common.activemq.exception.MQException;
import com.ydj.common.activemq.jms.JMSConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * <p> Date             :2018/9/23 </p>
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
public abstract class AbstractProducer {

    private JMSConnector jmsConnector;

    private ProducerConfigBean producerConfigBean;

    private static final Logger logger = LoggerFactory.getLogger(AbstractProducer.class);

    public void sendMsg(Serializable object) {
        if (null == this.producerConfigBean) {
            this.producerConfigBean = this.InitProducer();
            this.initJmsConnector();
        }
        this.jmsConnector.send(object);
    }

    private void initJmsConnector() {
        if (null != this.jmsConnector) {
            return;
        }
        this.jmsConnector = new JMSConnector();
        this.jmsConnector.setDestinationQueueName(this.producerConfigBean.getDestinationQueueName());
        this.jmsConnector.setJmsTemplate(this.producerConfigBean.getJmsTemplate());
        this.jmsConnector.setBatchSize(this.producerConfigBean.getBatchSize());
        this.jmsConnector.setIntervalTimeInMillisOfCommit(this.producerConfigBean.getIntervalTimeInMilisOfCommit());
        this.jmsConnector.setThreadName(this.producerConfigBean.getThreadName());
        try {
            this.jmsConnector.afterPropertiesSet();
        } catch (Exception e) {
            logger.info("JmsConnector run afterPropertiesSet Error!");
            throw new MQException(e);
        }
    }

    protected abstract ProducerConfigBean InitProducer();
}
