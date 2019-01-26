package com.ydj.workqueues.controller;

import com.ydj.hello.producer.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rabbitmq/workqueues")
public class WorkQueuesController {

    @Autowired
    private RabbitMQProducer rabbitMQProducer;

    @RequestMapping(value = "test")
    public String send() {
        rabbitMQProducer.send();
        return "success";
    }

}
