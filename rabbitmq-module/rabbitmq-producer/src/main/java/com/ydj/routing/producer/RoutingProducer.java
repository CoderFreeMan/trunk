package com.ydj.routing.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoutingProducer {

    /**
     * log
     */
    private static final Logger logger = LoggerFactory.getLogger(RoutingProducer.class);

    @Autowired
    private RabbitTemplate template;

    @Autowired(required = false)
    private DirectExchange direct;

    public void send() {
        String routingKey;
        for (int i = 0; i < 400000; i++) {
            if (i % 2 == 0) {
                routingKey = "error";
            } else {
                routingKey = "warning";
            }
            logger.info(routingKey + i);
            this.template.convertAndSend(direct.getName(), routingKey, routingKey.equals("error") ? ("error" + i) : ("warning" + i));
        }
    }

}
