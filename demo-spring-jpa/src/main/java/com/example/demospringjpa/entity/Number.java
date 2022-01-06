package com.example.demospringjpa.entity;

import lombok.Getter;

import javax.persistence.MappedSuperclass;

@Getter
@MappedSuperclass
public class Number {
    private static final int MIN = 1;

    private final int number;

    public Number(final int number) {
        if (number < MIN) {
            throw new IllegalArgumentException("Number 값이 최소값 보다 작습니다. number : " + number);
        }
        this.number = number;
    }
}
