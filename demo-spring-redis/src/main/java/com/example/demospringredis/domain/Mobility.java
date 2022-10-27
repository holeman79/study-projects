package com.example.demospringredis.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class Mobility {

    private Long batteryId;

    private String name;

    private Double value1;

    //private LocalDateTime interfacedTime;


    public void updateName(final String name) {
        this.name = name;
    }

}
