package com.example.demospringredis.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MobilityRepository extends CrudRepository<Mobility, Long> {
    List<Mobility> findByBatteryState(final BatteryState batteryState);
}
