package com.example.demospringredis.domain.redis.battery;

public class PowerState {
    private double maxChargePower;

    private double maxDischargePower;

    private double realPower;

    public PowerState(final double maxChargePower, final double maxDischargePower, final double realPower) {
        this.maxChargePower = maxChargePower;
        this.maxDischargePower = maxDischargePower;
        this.realPower = realPower;
    }
}
