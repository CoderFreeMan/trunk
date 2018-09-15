package com.ydj.routing.controller;

import com.ydj.routing.producer.RoutingProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rabbitmq/routing")
public class RoutingController {

    @Autowired
    private RoutingProducer routingProducer;

    @RequestMapping(value = "test")
    public String send() {
        routingProducer.send();
        return "success";
    }

}
