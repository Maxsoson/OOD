package com.ecomonitoring;

public class Measure {

    private double value;
    private double limit;

    public Measure(double value, double limit) {
        this.value = value;
        this.limit = limit;
    }

    // Друга версія конструктора — під твій Main
    public Measure(double value) {
        this.value = value;
        this.limit = 100.0; // можна підставити будь-яку межу
    }

    public double getValue() {
        return value;
    }

    public double getLimit() {
        return limit;
    }
}
