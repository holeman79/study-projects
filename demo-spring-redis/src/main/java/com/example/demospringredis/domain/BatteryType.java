package com.example.demospringredis.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Getter
@RequiredArgsConstructor
public enum BatteryType {
    LITHIUM_32_CELLS(32, "리튬 32셀 배터리"),
    LITHIUM_64_CELLS(64, "리튬 64셀 배터리"),
    LEAD_ACID(0, "납축 배터리");

    private static final int NUMBER_OF_CELLS_IN_A_MODULE = 8;

    private static final int NUMBER_OF_TEMPER_SENSOR_COUNT = 3;

    private final int numberOfCells;

    private final String description;

    public int getModuleCount() {
        return numberOfCells / NUMBER_OF_CELLS_IN_A_MODULE;
    }

    public int getTemperatureCount() {
        return getModuleCount() * NUMBER_OF_TEMPER_SENSOR_COUNT;
    }

    public boolean isLeadAcid() {
        return Objects.equals(this, LEAD_ACID);
    }

    public boolean isLithium() {
        return Objects.equals(this, LITHIUM_32_CELLS) || Objects.equals(this, LITHIUM_64_CELLS);
    }
}
