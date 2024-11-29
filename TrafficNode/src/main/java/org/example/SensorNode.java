package org.example;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SensorNode {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 8080);
        SensorNodeClient client = new SensorNodeClient(socket);

        List<Sensor> sensors = new ArrayList<>();
        sensors.add(new SpeedSensor("Speed Sensor"));
        sensors.add(new VehicleCountSensor("Vehicle Count Sensor"));
        sensors.add(new TemperatureSensor("Temperature Sensor 1"));


        while (true) {
            for (Sensor sensor : sensors) {
                TrafficData data = sensor.generateData();
                client.sendData(data);
            }
            Thread.sleep(6000);
        }
    }
}
