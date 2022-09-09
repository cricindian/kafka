package com.example.Kafka.controller;

import com.example.Kafka.dto.Request;
import com.example.Kafka.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/kafka/v1/")
public class KafkaController {

    private static final Logger logger = LoggerFactory.getLogger(KafkaController.class);

    @Autowired
    KafkaProducer producer;

    @PostMapping("/sendmessage")
    public ResponseEntity<String> sendMessage(@Valid @RequestBody Request request){
        logger.info("Request : "+ request.toString());
        producer.sendMessage(request);
        return new ResponseEntity<>(request.getMessage(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/sendmessage/string")
    public ResponseEntity<String> sendMessageStr(@Valid @RequestBody Request request){
        logger.info("Request : "+ request.toString());
        producer.sendMessage(request.getMessage());
        return new ResponseEntity<>(request.getMessage(), HttpStatus.ACCEPTED);
    }


}
