package com.example.healthmonitoringsystem;

public class Pressure {
    int pressureUp, pressureLow, pulse;
    boolean tachycardia;
    String dataMeasurement;

    public Pressure(int pressureUp, int pressureLow, int pulse, String dataMeasurement, boolean tachycardia) {
        this.pressureUp = pressureUp;
        this.pressureLow = pressureLow;
        this.pulse = pulse;
        this.tachycardia = tachycardia;
        this.dataMeasurement = dataMeasurement;
    }
}