package com.example.demospringredis.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum RentalState {
    RENTAL( "대여중"),
    WAITING( "미대여");

    private final String description;
}
