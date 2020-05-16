package com.example.healthmonitoringsystem;

public class Pressure {
    int PressureUp, PressureLow, Pulse;
    boolean Tachycardia;
    String DataMeasurement;

    public Pressure(int PressureUp, int PressureLow, int Pulse, String DataMeasurement, boolean Tachycardia) {
        this.PressureUp = PressureUp;
        this.PressureLow = PressureLow;
        this.Pulse = Pulse;
        this.Tachycardia = Tachycardia;
        this.DataMeasurement = DataMeasurement;
    }
}
