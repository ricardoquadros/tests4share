package com.example.consumer.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageListener {

    @KafkaListener(topics = "example_topic", groupId = "group_id")
    public void listen(String message) {
        System.out.println("Mensagem recebida: " + message);
    }
}
