package com.example.Kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration {

    @Bean(name = "TOPIC-STRING")
    public NewTopic createTopicStr(){
        return TopicBuilder.name("TOPIC-STRING")
//                .partitions(10)
        .build();

    }

    @Bean(name = "TOPIC-JSON")
    public NewTopic createTopicJson(){
        return TopicBuilder.name("TOPIC-JSON")
//                .partitions(10)
                .build();

    }
}
