package org.example;

import java.util.Random;

public class TemperatureSensor extends Sensor {
    private final Random random = new Random();

    public TemperatureSensor(String sensorName) {
        super(sensorName);
    }

    @Override
    public TrafficData generateData() {
        double temperature = 10 + random.nextDouble() * 30;
        return new TrafficData(sensorName, "Temperature", 0, 0, temperature);
    }
}
