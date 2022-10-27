package com.example.demospringredis.domain.redis.battery;

import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
public enum BatteryOperationState {
    DRIVING(2, "운행", "Driving"),
    CHARGING(3, "충전", "Charging"),
    FAULT_ON_BATTERY(6, "배터리장애", "FaultOnBattery"),
    POWER_OFF(7, "전원 Off", "PowerOff"),

    // code 값이 minus로 정의되는 상태들은 직접 정의한 상태
    NONE(-1, "알수없음", "None"),
    FAULT_ON_INTERFACE(-5, "수신장애", "FaultOnInterface");

    private final int code;

    private final String description;

    private final String englishDescription;

    private static final Map<Integer, BatteryOperationState> batteryOperationStateMap = Collections.unmodifiableMap(
            Stream.of(BatteryOperationState.values()).collect(Collectors.toMap(batteryOperationState -> batteryOperationState.code, Function.identity())));

    public static BatteryOperationState find(final int code) {
        BatteryOperationState BatteryOperationState = batteryOperationStateMap.get(code);
        if (Objects.isNull(BatteryOperationState)) {
            return NONE;
        }
        return BatteryOperationState;
    }

    public boolean isPowerOff() {
        return Objects.equals(this, POWER_OFF);
    }

    public boolean isFaultOnInterface() {
        return Objects.equals(this, FAULT_ON_INTERFACE);
    }

    public String getDescription() {
        return description;
    }

    public String getEnglishDescription() {
        return englishDescription;
    }
}
