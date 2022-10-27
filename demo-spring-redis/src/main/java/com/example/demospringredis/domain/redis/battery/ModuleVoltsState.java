package com.example.demospringredis.domain.redis.battery;

import java.util.List;

public class ModuleVoltsState {
    private List<Double> moduleVolts;

    public ModuleVoltsState(final List<Double> moduleVolts) {
        this.moduleVolts = moduleVolts;
    }
}
