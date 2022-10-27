package com.example.demospringredis.domain.redis.battery;

public enum FaultType {
    FAULT_RELAY_DRIVE_CIRCUIT("Relay 구동회로(HW) 고장"),
    FAULT_AUX_POWER("12V IOT 전원 공급 회로(HW) 고장"),
    FAULT_ELECTRIC_CURRENT_SENSOR("팩 전류 센서 고장"),
    FAULT_MEASURING_CIRCUIT("Cell Voltage/Temper 측정 회로(HW) 고장"),
    FAULT_MCU("BMS MCU 고장"),

    FAULT_ELECTRIC_CURRENT_OVER("충전 전류 과다 Fault"),
    FAULT_ELECTRIC_CURRENT_UNDER("방전 전류 부족 Fault"),
    FAULT_STATE_OF_CHARGE_UNDER("SOC Low Fault(5% 이하)"),
    FAULT_STATE_OF_HEALTH_UNDER("SOH Low Fault(80% 이하)"),

    FAULT_RELAY_AGE("Relay 열화(사용 횟수 초과)"),
    FAULT_RELAY_OPEN("Relay Open 상태 융착"),
    FAULT_RELAY_WELD("Relay Close 상태 융착"),

    FAULT_CELL_VOLT_OVER("Cell 고전압 Fault(3.65V 이상)"),
    FAULT_CELL_VOLT_UNDER("Cell 저전압 Fault(2.5V 이하)"),
    FAULT_CELL_VOLT_DIFFERENCE("Cell 전압 편차 Fault(0.2V 이상)"),
    FAULT_TEMPERATURE_OVER("고온 Fault(55도씨 이상)"),
    FAULT_TEMPERATURE_UNDER("저온 Fault(-20도씨 이하)"),
    FAULT_TEMPERATURE_DIFFERENCE("온도 편차 Fault(10도씨 이상)"),
    FAULT_PACK_VOLT_OVER("Pack 고전압 Fault(58.4V 이상)"),
    FAULT_PACK_VOLT_UNDER("Pack 저전압 Fault(40.0V 이하)")
    ;

    private final String description;

    FaultType(final String description) {
        this.description = description;
    }
}
