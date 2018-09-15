package com.ydj.topic.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicProducer {

    /**
     * log
     */
    private static final Logger logger = LoggerFactory.getLogger(TopicProducer.class);

    @Autowired
    private RabbitTemplate template;

    @Autowired(required = false)
    private TopicExchange topic;

    public void send() {
        String routingKey;
        for (int i = 0; i < 4000; i++) {
            if (i % 2 == 0) {
                routingKey = i + ".error";
            } else {
                routingKey = i + ".warning";
            }
            logger.info(routingKey);
            this.template.convertAndSend(topic.getName(), routingKey, routingKey.equals(i + ".error") ? ("error" + i) : ("warning" + i));
        }
    }

}
