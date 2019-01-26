package com.ydj.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.MessageListener;

/**
 * <p> Date             :2018/9/16 </p>
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
public class MyMessageListener implements MessageListener<String, String> {
    public final static Logger logger = LoggerFactory.getLogger(MyMessageListener.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Override//此方法处理消息
    public void onMessage(ConsumerRecord<String, String> data) {

        String topic = data.topic();//消费的topic
        logger.info("-------------recieve message from {} topic-------------", topic);
        logger.info("partition:{}", String.valueOf(data.partition()));//消费的topic的分区
        logger.info("offset:{}", String.valueOf(data.offset()));//消费者的位置
        logger.info("get message from {} topic : {}", topic, data.value());//接收到的消息
    }
}
