package com.consulta_creditos_api.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @KafkaListener(topics = "consulta-creditos-log", groupId = "log-consumer-group")
    public void consumeLog(ConsumerRecord<String, String> record) {
        System.out.println("Mensagem recebida no tópico Kafka: " + record.value());
    }
}
