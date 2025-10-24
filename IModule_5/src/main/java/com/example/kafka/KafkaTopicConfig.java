package com.example.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic myNewTopic() {
        return TopicBuilder.name("create")
                .partitions(1) 
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic anotherTopic() {
        return TopicBuilder.name("delete")
                .partitions(1)
                .replicas(1)
                .build();
    }
}