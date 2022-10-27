package com.example.demospringredis.domain.redis;

import com.example.demospringredis.domain.redis.battery.*;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BatteryState {
    private CellVoltsState cellVoltsState;

    private TemperaturesState tempersState;

    private ModuleVoltsState moduleVoltsState;

    private double inverterVolt;

    private PackState packState;

    private BatteryOperationState batteryOperState;

    private FaultLevel faultLevel;

    private int relayState;

    private PowerState powerState;

    private double availableCapacity;

    private WarningStates warningStates;

    private FaultStates faultStates;

    @Builder
    private BatteryState(final CellVoltsState cellVoltsState, final TemperaturesState tempersState, final ModuleVoltsState moduleVoltsState,
                         final double inverterVolt, final PackState packState, final BatteryOperationState batteryOperState,
                         final FaultLevel faultLevel, final int relayState, final PowerState powerState,
                         final double availableCapacity, final WarningStates warningStates, final FaultStates faultStates) {
        this.cellVoltsState = cellVoltsState;
        this.tempersState = tempersState;
        this.moduleVoltsState = moduleVoltsState;
        this.inverterVolt = inverterVolt;
        this.packState = packState;
        this.batteryOperState = batteryOperState;
        this.faultLevel = faultLevel;
        this.relayState = relayState;
        this.powerState = powerState;
        this.availableCapacity = availableCapacity;
        this.warningStates = warningStates;
        this.faultStates = faultStates;
    }

    public boolean isPowerOff() {
        return batteryOperState.isPowerOff();
    }

    public boolean isFaultOnInterface() {
        return batteryOperState.isFaultOnInterface();
    }

    public void updateStateToFaultOnInterface() {
        this.batteryOperState = BatteryOperationState.FAULT_ON_INTERFACE;
    }
}
