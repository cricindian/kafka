package com.example.Kafka.producer;

import com.example.Kafka.dto.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, Request> kafkaTemplateJson;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplateStr;

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    public void sendMessage(String message){
        logger.info("Message sent : "+message);
        kafkaTemplateStr.send("TOPIC-STRING", message);
    }

    public void sendMessage(Request request){
        logger.info("Sending message : "+ request);
        Message<Request> message =
                MessageBuilder.withPayload(request)
                .setHeader(KafkaHeaders.TOPIC, "TOPIC-JSON")
                .build();
        kafkaTemplateJson.send(message);
    }


}
