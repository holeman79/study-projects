package com.example.demospringredis.domain;

import com.example.demospringredis.domain.redis.BatteryMobilityState;
import com.example.demospringredis.domain.redis.BatteryState;
import com.example.demospringredis.domain.redis.battery.BatteryOperationState;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.groupingBy;

@Getter
@Slf4j
public class BatteryMobilityStates {
    private final List<BatteryMobilityState> states;

    public BatteryMobilityStates(final Iterable<BatteryMobilityState> states) {
        this(StreamSupport.stream(states.spliterator(), false)
                .collect(Collectors.toList()));
    }

    public BatteryMobilityStates(final List<BatteryMobilityState> states) {
        List<BatteryMobilityState> result = new ArrayList<>();
        log.info("states.size() : " + states.size());
        for (BatteryMobilityState batteryMobilityState : states) {

            if (!Objects.isNull(batteryMobilityState)) {
                log.info("state : " + batteryMobilityState);
                log.info("batteryId : " + batteryMobilityState.getId());
                log.info("mobilityId : " + batteryMobilityState.getMobilityId());
                if (!Objects.isNull(batteryMobilityState.getBatteryState())) {
                    if (batteryMobilityState.isLithiumBattery()) {
                        result.add(batteryMobilityState);
                    }
                }
            }
        }
        this.states = Collections.unmodifiableList(result);

//        List<BatteryMobilityState> list = new ArrayList<>();
//        System.out.println("states.size() : " + states.size());
//        for (BatteryMobilityState state : states) {
//            System.out.println("state : " + state);
//            System.out.println("batteryId : " + state.getId());
//            System.out.println("mobilityId : " + state.getMobilityId());
//            if (!Objects.isNull(state.getBatteryState())) {
//                if (state.isLithiumBattery()) {
//                    list.add(state);
//                }
//            }
//        }
//        this.states = list;
    }

    public long calculateNumbersOfPowerOffState() {
        return states.stream()
                .map(BatteryMobilityState::getBatteryState)
                .filter(BatteryState::isPowerOff)
                .count();
    }

    public List<OperationStateCount> calculateOperationStateCount() {
        Map<BatteryOperationState, Long> operationStateCountMap = states
                .stream()
                .collect(groupingBy(operationState -> operationState.getBatteryState().getBatteryOperState(), Collectors.counting()));
        return Arrays.stream(BatteryOperationState.values())
                .map(operationState -> {
                    Long count = operationStateCountMap.get(operationState);
                    if (count == null) count = 0L;
                    return new OperationStateCount(operationState, count);
                })
                .collect(Collectors.toList());
    }

    public List<BatteryMobilityState> extractFaultOnInterfaceStates() {
        return states.stream()
                .filter(BatteryMobilityState::checkFaultOnInterface)
                .map(BatteryMobilityState::updateFaultOnInterface)
                .collect(Collectors.toUnmodifiableList());
    }
}
