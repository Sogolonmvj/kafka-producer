package com.vieira.sogolon.kafka.service;

import com.vieira.sogolon.kafka.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private static final Logger logger = LoggerFactory.getLogger(MessageService.class);

    @Value("${topic.store}")
    private String topicStore;

    @Autowired
    private KafkaTemplate<Message, Message> kafkaTemplate;

    public void sendMessage(Message message) {
        logger.info("Message -> {}", message);
        this.kafkaTemplate.send(topicStore, message);
    }
}
