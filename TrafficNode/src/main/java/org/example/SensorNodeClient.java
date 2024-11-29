package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class SensorNodeClient {
    private final Socket socket;
    private final PrintWriter out;

    public SensorNodeClient(Socket socket) throws IOException {
        this.socket = socket;
        this.out = new PrintWriter(socket.getOutputStream(), true);
    }

    public void sendData(TrafficData data) {
        out.println(data);
    }
}
