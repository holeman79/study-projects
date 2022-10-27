package com.example.demospringredis.temp;

import lombok.Builder;

public class Battery {
    private Long id;

    private BatteryState batteryState;

    private int voltage;

    @Builder
    private Battery(final Long id, final BatteryState batteryState, int voltage) {
        this.id = id;
        this.batteryState = batteryState;
        this.voltage = voltage;
    }
}
