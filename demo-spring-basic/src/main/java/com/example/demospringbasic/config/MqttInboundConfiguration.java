package com.example.demospringbasic.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class MqttInboundConfiguration {
    private final MqttProperties mqttProperties;

    @PostConstruct
    private void after() {
        log.info("after");
    }


}
