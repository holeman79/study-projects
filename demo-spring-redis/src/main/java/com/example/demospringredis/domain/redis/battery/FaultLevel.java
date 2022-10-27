package com.example.demospringredis.domain.redis.battery;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum FaultLevel {
    NORMAL(0, "정상"),
    WARNING(1, "경고"),
    FAULT(2, "결함");

    private final int code;

    private final String description;

    private static final Map<Integer, FaultLevel> faultLevelMap = Collections.unmodifiableMap(
            Stream.of(FaultLevel.values()).collect(Collectors.toMap(faultLevel -> faultLevel.code, Function.identity())));

    public static FaultLevel find(final int code) {
        FaultLevel faultLevel = faultLevelMap.get(code);
        if (Objects.isNull(faultLevel)) {
            throw new IllegalArgumentException("Fault Level 값이 없습니다. code : " + code);
        }
        return faultLevel;
    }

    FaultLevel(final int code, final String description) {
        this.code = code;
        this.description = description;
    }
}
