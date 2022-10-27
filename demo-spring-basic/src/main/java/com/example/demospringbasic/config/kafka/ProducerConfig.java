package com.example.demospringbasic.config.kafka;

import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

import static org.apache.kafka.clients.producer.ProducerConfig.*;

@EnableKafka
@Configuration
public class ProducerConfig {
    @Bean
    public ProducerFactory<String, TrainingKafkaMessage> producerFactory() {
        Map<String, Object> config = new HashMap<>();
//        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "b-2.recofitkafkaclust.01fdq3.c4.kafka.ap-northeast-2.amazonaws.com:9094,b-1.recofitkafkaclust.01fdq3.c4.kafka.ap-northeast-2.amazonaws.com:9094");
        config.put(BOOTSTRAP_SERVERS_CONFIG, "3.39.234.99:9092");
        config.put(KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean
    public KafkaTemplate<String, TrainingKafkaMessage> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

}
