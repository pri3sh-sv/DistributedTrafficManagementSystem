package org.example;

import java.io.*;

public class TrafficDashboard {
    private static final String DATA_FILE = "trafficData.txt";
    private static long lastReadPosition = 0;

    public static void main(String[] args) {

        while (true) {
            readDataFromFile();
            try {
                Thread.sleep(3000); // 5 seconds
            } catch (InterruptedException e) {
                System.err.println("Error sleeping: " + e.getMessage());
            }
        }
    }

    public static void readDataFromFile() {
        File file = new File(DATA_FILE);
        if (!file.exists()) {
            System.out.println("Data file does not exist.");
            return;
        }

        try (RandomAccessFile reader = new RandomAccessFile(file, "r")) {
            reader.seek(lastReadPosition);

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Dashboard received data: " + line);
            }

            lastReadPosition = reader.getFilePointer();

        } catch (IOException e) {
            System.err.println("Error reading data from file: " + e.getMessage());
        }
    }
}