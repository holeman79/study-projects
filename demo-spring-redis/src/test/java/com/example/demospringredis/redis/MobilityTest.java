package com.example.demospringredis.redis;

import com.example.demospringredis.domain.BatteryState;
import com.example.demospringredis.domain.Mobility;
import com.example.demospringredis.domain.MobilityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MobilityTest {

    @Autowired
    private MobilityRepository mobilityRepository;

    @Test
    void save() {
        Mobility mobility = Mobility.builder()
                .id(1L)
                .name("mobility 1")
                .batteryState(BatteryState.DRIVING)
                .build();
        Mobility mobility2 = Mobility.builder()
                .id(2L)
                .name("mobility 2")
                .batteryState(BatteryState.DRIVING)
                .build();
        Mobility mobility3 = Mobility.builder()
                .id(3L)
                .name("mobility 3")
                .batteryState(BatteryState.FAULT_ON_BATTERY)
                .build();

        mobilityRepository.save(mobility);
        mobilityRepository.save(mobility2);
        mobilityRepository.save(mobility3);

//        Optional<Mobility> byId = mobilityRepository.findById(1L);
//
//        System.out.println(byId.get().getName());

        //mobilityRepository.delete(mobility);
    }
}
