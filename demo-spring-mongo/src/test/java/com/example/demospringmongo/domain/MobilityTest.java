package com.example.demospringmongo.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class MobilityTest {
    @Autowired
    private MobilityMongoRepository mobilityMongoRepository;

    @Test
    void test() {
        mobilityMongoRepository.save(Mobility.builder()
                .mobiId(5L)
                //.mobiTypCd("C01")
                .eventCode("Driving")
                .battery(Battery.builder()
                        .Cell01(Cell.volt(3.5))
                        .Cell02(Cell.volt(3.2))
                        .Cell03(Cell.volt(3.8))
                        .build())
                //.batteryType(BatteryType.ACID)
                .localDateTime(LocalDateTime.now())
                //.value1(null)
                .build());
    }

    @Test
    void get() {
        List<Mobility> byMobiId = mobilityMongoRepository.findByMobiId(5L);
        System.out.println(byMobiId);
    }
}
