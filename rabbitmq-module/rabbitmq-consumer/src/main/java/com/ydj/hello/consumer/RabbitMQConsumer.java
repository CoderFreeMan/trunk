package com.ydj.hello.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "test")
public class RabbitMQConsumer {

    @RabbitHandler
    public void test(String message) {
        System.out.println(message);
    }

}
