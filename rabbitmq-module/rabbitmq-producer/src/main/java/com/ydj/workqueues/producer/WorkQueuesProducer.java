package com.ydj.workqueues.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkQueuesProducer {

    /**
     * log
     */
    private static final Logger logger = LoggerFactory.getLogger(WorkQueuesProducer.class);

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    public void send() {
        for (int i = 0; i < 100000; i++) {
            logger.info(i + "");
            this.template.convertAndSend(queue.getName(), "hello" + i);
        }
    }

}
