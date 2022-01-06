package com.example.demospringredis.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@RedisHash("mobilities")
public class Mobility {
    @Id
    private Long id;

    private String name;

    private BatteryState batteryState;

    private LocalDateTime interfacedTime;

    @Builder
    private Mobility(final Long id, final BatteryState batteryState, final String name) {
        this.id = id;
        this.name = name;
        this.batteryState = batteryState;
        this.interfacedTime = LocalDateTime.now();
    }
}
