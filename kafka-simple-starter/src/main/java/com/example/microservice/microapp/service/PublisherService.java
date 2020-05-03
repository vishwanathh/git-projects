package com.example.microservice.microapp.service;

import com.example.microservice.microapp.entity.Messages;
import com.example.microservice.microapp.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {
    private static final Logger logger = LoggerFactory.getLogger(PublisherService.class);
    private static final String TOPIC = "errors";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        logger.info("publish message : " + message);
        this.kafkaTemplate.send(TOPIC, message);
    }

}
