package com.example.demospringredis.domain.redis.battery;

import java.util.List;

public class TemperaturesState {
    private List<Double> temperatures;

    private double maxTemperature;

    private double minTemperature;

    private double averageTemperature;

    private int maxTemperatureNumber;

    private int minTemperatureNumber;

    public TemperaturesState(final List<Double> temperatures, final double maxTemperature, final double minTemperature,
                             final double averageTemperature, final int maxTemperatureNumber, final int minTemperatureNumber) {
        this.temperatures = temperatures;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.averageTemperature = averageTemperature;
        this.maxTemperatureNumber = maxTemperatureNumber;
        this.minTemperatureNumber = minTemperatureNumber;
    }
}
