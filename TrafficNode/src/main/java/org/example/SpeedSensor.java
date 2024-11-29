package org.example;

import java.util.Random;

public class SpeedSensor extends Sensor {
    private final Random random;

    public SpeedSensor(String sensorName) {
        super(sensorName);
        this.random = new Random();
    }

    @Override
    public TrafficData generateData() {
        double speed = 30 + random.nextDouble() * 70;
        return new TrafficData(sensorName, "Speed", 0, speed, 0);
    }
}
