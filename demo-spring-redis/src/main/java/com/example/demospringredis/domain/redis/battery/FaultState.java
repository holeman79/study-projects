package com.example.demospringredis.domain.redis.battery;

public class FaultState {
    private final FaultType faultType;

    private final boolean hasProblem;

    public FaultState(final FaultType faultType, final boolean hasProblem) {
        this.faultType = faultType;
        this.hasProblem = hasProblem;
    }
}
