package com.ydj.topic.controller;

import com.ydj.topic.producer.TopicProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rabbitmq/topic")
public class TopicController {

    @Autowired
    private TopicProducer topicProducer;

    @RequestMapping(value = "test")
    public String send() {
        topicProducer.send();
        return "success";
    }

}
