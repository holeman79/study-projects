package com.example.demospringredis.domain.redis;

import lombok.Getter;

@Getter
public class GpsState {
    private double latitude;

    private double longitude;

    public void update(final double latitude, final double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
