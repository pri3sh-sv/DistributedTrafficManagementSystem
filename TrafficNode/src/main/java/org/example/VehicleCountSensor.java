package org.example;

import java.util.Random;

public class VehicleCountSensor extends Sensor {
    private final Random random;

    public VehicleCountSensor(String sensorName) {
        super(sensorName);
        this.random = new Random();
    }

    @Override
    public TrafficData generateData() {

        int vehicleCount = random.nextInt(200);
        return new TrafficData(sensorName, "Vehicle Count", vehicleCount, 0.0, 0);
    }
}
