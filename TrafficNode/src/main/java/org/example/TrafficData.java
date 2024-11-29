package org.example;

import java.text.SimpleDateFormat;

public class TrafficData {
    private final String sensorName;
    private final String sensorType;
    private final int vehicleCount;
    private final double speed;
    private final double temperature;
    private final String timestamp;

    public TrafficData(String sensorName, String sensorType, int vehicleCount, double speed, double temperature) {
        this.sensorName = sensorName;
        this.sensorType = sensorType;
        this.vehicleCount = vehicleCount;
        this.speed = speed;
        this.temperature = temperature;
        this.timestamp = getCurrentTimestamp();
    }

    private String getCurrentTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(System.currentTimeMillis());
    }

    @Override
    public String toString() {
        if (sensorType.equals("Speed")) {
            return String.format("[%s] %s | Speed: %.2f km/h | Timestamp: %s", sensorName, sensorType, speed, timestamp);
        } else if (sensorType.equals("Vehicle Count")) {
            return String.format("[%s] %s | Vehicles: %d | Timestamp: %s", sensorName, sensorType, vehicleCount, timestamp);
        } else if (sensorType.equals("Temperature")) {
            return String.format("[%s] %s | Temperature: %.2f°C | Timestamp: %s", sensorName, sensorType, temperature, timestamp);
        }
        return "";
    }
}
