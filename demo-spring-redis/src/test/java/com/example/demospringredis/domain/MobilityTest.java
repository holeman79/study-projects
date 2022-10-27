package com.example.demospringredis.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisKeyValueTemplate;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
//@Import(RedisConfig.class)
public class MobilityTest {
    @Autowired
    private RedisTemplate<String, Mobility> redisTemplate;

    @Autowired
    private RedisKeyValueTemplate redisKeyValueTemplate;


    @Test
    void save() {
        HashOperations<String, String, Mobility> hashOperations = redisTemplate.opsForHash();
        hashOperations.put("mobilities", "4", Mobility.builder()
                .batteryId(4L)
                .name("mobility 4")
                //.value1(10.0)
                .build());
        //Mobility mobility = hashOperations.get("mobility", 1L);
        //Map<Long, Mobility> mobility = hashOperations.entries("mobility");
        //System.out.println(mobility);
    }

    @Test
    void get() {
        HashOperations<String, String, Mobility> hashOperations = redisTemplate.opsForHash();
        Mobility mobility = hashOperations.get("mobilities", 1L);

        //mobility.updateName("mobility 20");
        //redisKeyValueTemplate.update(mobility);
        System.out.println(mobility);
    }
}