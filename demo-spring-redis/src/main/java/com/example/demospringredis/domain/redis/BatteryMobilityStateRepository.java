package com.example.demospringredis.domain.redis;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatteryMobilityStateRepository extends CrudRepository<BatteryMobilityState, Long> {
}
