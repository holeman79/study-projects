package com.example.demospringjpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@Configuration
public class BaseConfig {
    @Bean
    public AuditorAware<String> auditorProvider() {
        //        return () -> Optional.of(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        return () -> Optional.of("ADMIN");
    }
}
