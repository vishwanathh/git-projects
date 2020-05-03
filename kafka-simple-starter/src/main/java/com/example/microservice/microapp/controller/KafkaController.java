package com.example.microservice.microapp.controller;

import com.example.microservice.microapp.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    @Autowired
    private PublisherService publisher;

    @PostMapping(value = "/publish")
    public void publishToKafkaTopic(@RequestParam("message") String message) {
        publisher.sendMessage(message);
    }
}
