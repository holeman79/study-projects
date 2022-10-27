package com.example.demospringbasic.api;

import com.example.demospringbasic.config.kafka.TrainingKafkaMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootTest
public class KafkaProducerTest {
    @Autowired
    private KafkaTemplate<String, TrainingKafkaMessage> kafkaTemplate;

    @Test
    void sendMessage() {
        kafkaTemplate.send("training-create", TrainingKafkaMessage.builder()
                .programName("program A")
                .gymId(5L)
                .gymName("바른 짐")
                .memberId("holeman79").build());
    }


}
