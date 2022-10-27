package com.example.demospringredis.domain.redis.battery;

import lombok.Getter;

@Getter
public class PackState {
    private double packVolt;

    private Double packStateOfCharge;

    private double packStateOfHealth;

    private double packElectricCurrent;

    public PackState(final double packVolt, final Double packStateOfCharge, final double packStateOfHealth, final double packElectricCurrent) {
        this.packVolt = packVolt;
        this.packStateOfCharge = packStateOfCharge;
        this.packStateOfHealth = packStateOfHealth;
        this.packElectricCurrent = packElectricCurrent;
    }
}
