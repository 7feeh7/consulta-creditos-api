package com.consulta_creditos_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaPublisherService {
    private static final String TOPIC = "consulta-creditos-log";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void publishConsulta(String mensagem) {
        kafkaTemplate.send(TOPIC, mensagem);
    }
}
