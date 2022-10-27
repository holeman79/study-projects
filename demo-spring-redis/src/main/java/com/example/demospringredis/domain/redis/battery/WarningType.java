package com.example.demospringredis.domain.redis.battery;

public enum WarningType {
    WARN_ELECTRIC_CURRENT_OVER("충전 전류 과다 Warning"),
    WARN_ELECTRIC_CURRENT_UNDER("방전 전류 부족 Warning"),
    WARN_STATE_OF_CHARGE_OVER("SOC High Warning(95% 이상)"),
    WARN_STATE_OF_CHARGE_UNDER("SOC Low Warning(10% 이하)"),
    WARN_CELL_VOLT_OVER("Cell 고전압 Warning(3.6V 이상)"),
    WARN_CELL_VOLT_UNDER("Cell 저전압 Warning(2.65V 이하)"),
    WARN_CELL_VOLT_DIFFERENCE("Cell 전압 편차(0.1V 이상)"),
    WARN_TEMPERATURE_OVER("고온 Warning(45도씨 이상)"),
    WARN_TEMPERATURE_UNDER("저온 Warning(0도씨 이하)"),
    WARN_TEMPERATURE_DIFFERENCE("온도 편차 Warning(5도씨 이상)"),
    WARN_PACK_VOLT_OVER("Pack 고전압 Warning(57.6V 이상)"),
    WARN_PACK_VOLT_UNDER("Pack 저전압 Warning(42.0V 이하)");

    private final String description;

    WarningType(final String description) {
        this.description = description;
    }
}
