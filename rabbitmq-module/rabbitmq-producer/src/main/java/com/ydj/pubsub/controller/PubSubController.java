package com.ydj.pubsub.controller;

import com.ydj.pubsub.producer.PubSubProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rabbitmq/pubsub")
public class PubSubController {

    @Autowired
    private PubSubProducer rabbitMQProducer;

    @RequestMapping(value = "test")
    public String send() {
        rabbitMQProducer.send();
        return "success";
    }

}
