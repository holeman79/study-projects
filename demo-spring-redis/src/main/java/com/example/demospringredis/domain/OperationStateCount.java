package com.example.demospringredis.domain;

import com.example.demospringredis.domain.redis.battery.BatteryOperationState;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class OperationStateCount {
    private final BatteryOperationState batteryOperationState;

    private final Long count;
}
