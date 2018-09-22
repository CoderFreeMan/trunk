package com.ydj.common.activemq.producer;

import org.springframework.jms.core.JmsTemplate;

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
public class ProducerConfigBean {

    private String destinationQueueName;

    private int batchSize = 3000;

    private int intervalTimeInMilisOfCommit = 10000;

    private String threadName;

    private JmsTemplate jmsTemplate;

    public ProducerConfigBean(String destinationQueueName, String threadName, JmsTemplate jmsTemplate) {
        this.destinationQueueName = destinationQueueName;
        this.threadName = threadName;
        this.jmsTemplate = jmsTemplate;
    }

    public String getDestinationQueueName() {
        return destinationQueueName;
    }

    public void setDestinationQueueName(String destinationQueueName) {
        this.destinationQueueName = destinationQueueName;
    }

    public int getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(int batchSize) {
        this.batchSize = batchSize;
    }

    public int getIntervalTimeInMilisOfCommit() {
        return intervalTimeInMilisOfCommit;
    }

    public void setIntervalTimeInMilisOfCommit(int intervalTimeInMilisOfCommit) {
        this.intervalTimeInMilisOfCommit = intervalTimeInMilisOfCommit;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
}
