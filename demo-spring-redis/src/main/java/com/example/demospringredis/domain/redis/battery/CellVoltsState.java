package com.example.demospringredis.domain.redis.battery;

import java.util.List;

public class CellVoltsState {
    private List<Double> cellVolts;

    private double maxCellVolt;

    private double minCellVolt;

    private double averageCellVolt;

    private int maxCellVoltNumber;

    private int minCellVoltNumber;

    public CellVoltsState(final List<Double> cellVolts, final double maxCellVolt, final double minCellVolt,
                          final double averageCellVolt, final int maxCellVoltNumber, final int minCellVoltNumber) {
        this.cellVolts = cellVolts;
        this.maxCellVolt = maxCellVolt;
        this.minCellVolt = minCellVolt;
        this.averageCellVolt = averageCellVolt;
        this.maxCellVoltNumber = maxCellVoltNumber;
        this.minCellVoltNumber = minCellVoltNumber;
    }
}
