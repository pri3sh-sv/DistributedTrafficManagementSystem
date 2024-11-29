package org.example;

public abstract class Sensor {
    protected String sensorName;

    public Sensor(String sensorName) {
        this.sensorName = sensorName;
    }

    public abstract TrafficData generateData();
}
