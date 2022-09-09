package com.example.Kafka.consumer;

import com.example.Kafka.dto.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "TOPIC-STRING", groupId = "myGroup")
    public void consumeMessage(String message){
        if(message != null)
            logger.info("Received message from Topic string:" + message);
    }

    @KafkaListener(topics = "TOPIC-JSON", groupId = "myGroup")
    public void consumeObject(Request request){
        if(request != null)
            logger.info("Received message from Topic json:" + request.getMessage());
    }
}
