package com.example.demospringredis.domain;

import lombok.Getter;

@Getter
public enum MobilityType {
    FORK_LIFT("지게차"),
    ELECTRIC_CARRIAGE("전동차");

    private String description;

    MobilityType(final String description) {
        this.description = description;
    }
}
