package com.example.demospringbasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DemoSpringBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBasicApplication.class, args);
	}

}
