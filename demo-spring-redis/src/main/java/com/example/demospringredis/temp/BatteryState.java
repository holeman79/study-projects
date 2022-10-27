package com.example.demospringredis.temp;

import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
public enum BatteryState {
    INITIAL(0, "Initial", "Battery Initial On"),
    DRIVING(2, "Driving", "운행"),
    CHARGING(3, "Charging", "충전"),
    FAULT_ON_BATTERY(6, "FaultOnBattery", "배터리장애"),
    POWER_OFF(7, "PowerOff", "전원 Off"),

    // code 값이 minus로 정의되는 상태들은 직접 정의한 상태
    NONE(-1, "None", "알수없음"),
    FAULT_ON_INTERFACE(-5, "FaultOnInterface", "수신장애");

    private final int code;

    private final String eventCode;

    private final String eventName;

    private static final Map<Integer, BatteryState> batteryStateMap = Collections.unmodifiableMap(
            Stream.of(BatteryState.values()).collect(Collectors.toMap(batteryState -> batteryState.code, Function.identity())));

    public static BatteryState find(final int code) {
        BatteryState batteryState = batteryStateMap.get(code);
        if (Objects.isNull(batteryState)) {
            return NONE;
        }
        return batteryState;
    }

    public boolean isSame(final BatteryState batteryState) {
        return Objects.equals(this, batteryState);
    }

    public String getEventCode() {
        return eventCode;
    }

    public String getEventName() {
        return eventName;
    }
}
