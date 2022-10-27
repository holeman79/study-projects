package com.example.demospringbasic.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Getter
@Setter
@ConfigurationProperties(prefix = "mqtt")
@Component
public class MqttProperties {

	private String url;
	private String clientId;
	private String topicPrefix;

}
