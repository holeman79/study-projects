package com.example.demospringredis.domain.redis.battery;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class WarningStates {
    private final List<WarningState> warningStates;
}
