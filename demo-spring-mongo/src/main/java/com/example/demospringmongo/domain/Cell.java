package com.example.demospringmongo.domain;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Cell {
    private BigDecimal voltage;

    private Cell(final BigDecimal voltage) {
        this.voltage = voltage;
    }

    public static Cell volt(final Double voltage) {
        return new Cell(BigDecimal.valueOf(voltage));
    }
}
