package com.vieira.sogolon.kafka.service;

import com.vieira.sogolon.kafka.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Value("${topic.store}")
    private String topicStore;

    @Autowired
    private KafkaTemplate<Student, String> kafkaTemplate;

    public void sendMessage(String student) {
        logger.info("Student -> {}", student);
        this.kafkaTemplate.send(topicStore, student);
    }
}
