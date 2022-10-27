package com.example.demospringredis.domain.redis.battery;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FaultStates {
    private final List<FaultState> faultStates;
}
