package com.example.demospringredis.domain.redis.battery;

public class WarningState {
    private WarningType warningType;

    private boolean hasProblem;

    public WarningState(final WarningType warningType, final boolean hasProblem) {
        this.warningType = warningType;
        this.hasProblem = hasProblem;
    }
}
