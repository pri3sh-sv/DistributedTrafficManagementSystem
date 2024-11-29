package org.example;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

public class CentralServer {
    private static final AtomicInteger clientCount = new AtomicInteger(0);
    private static final String DATA_FILE = "trafficData.txt";


    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Central Server started on port 8080...");

            File file = new File(DATA_FILE);
            if (!file.exists()) {
                file.createNewFile();
            }

            while (true) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    int clientId = clientCount.incrementAndGet();
                    System.out.println("Client " + clientId + " connected.");

                    new Thread(new ClientHandler(clientSocket, clientId, file)).start();
                } catch (IOException e) {
                    System.err.println("Error accepting client connection: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error starting server: " + e.getMessage());
        }
    }
}