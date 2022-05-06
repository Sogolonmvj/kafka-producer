package com.vieira.sogolon.kafka.resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vieira.sogolon.kafka.model.Student;
import com.vieira.sogolon.kafka.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student/save")
public class StudentResource {

    @Autowired
    StudentService studentService;

    private static final Logger logger = LoggerFactory.getLogger(StudentResource.class);

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody Student student) throws JsonProcessingException {

        logger.info(String.format("## Data sent by client: {%s}", student));

        ObjectMapper objectMapper = new ObjectMapper();
        String response = objectMapper.writeValueAsString(student);

        studentService.sendMessage(response);
        return ResponseEntity.ok().body("Student sent successfully: " + response);
    }
}
