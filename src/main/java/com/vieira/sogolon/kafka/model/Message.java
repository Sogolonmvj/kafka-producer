package com.vieira.sogolon.kafka.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Message {

    @Id
    private String id;
    private String message;
    private String author;
}
