package com.example.demospringbasic.domain;

import com.example.demospringbasic.generic.number.Number;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductNumber extends Number {
    private static final String INDICATION = "P";

    public ProductNumber(final int number) {
        super(number);
    }

    @Override
    public String toString() {
        return INDICATION + super.getNumber();
    }
}
