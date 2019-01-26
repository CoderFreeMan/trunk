package com.ydj.pubsub.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PubSubProducer {

    /**
     * log
     */
    private static final Logger logger = LoggerFactory.getLogger(PubSubProducer.class);

    @Autowired
    private RabbitTemplate template;

    @Autowired(required = false)
    private FanoutExchange fanout;

    public void send() {
        for (int i = 0; i < 100; i++) {
            logger.info(i + "");
            this.template.convertAndSend(fanout.getName(), "", "hello" + i);
        }
    }

}
