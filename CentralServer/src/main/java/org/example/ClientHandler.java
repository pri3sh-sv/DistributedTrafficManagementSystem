package org.example;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private final Socket clientSocket;
    private final int clientId;
    private final File dataFile;

    public ClientHandler(Socket clientSocket, int clientId, File dataFile) {
        this.clientSocket = clientSocket;
        this.clientId = clientId;
        this.dataFile = dataFile;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            String data;
            while ((data = in.readLine()) != null) {
                System.out.println("Received from client " + clientId + ": " + data);
                writeDataToFile(data);
            }
        } catch (IOException e) {
            System.err.println("Error handling client " + clientId + ": " + e.getMessage());
        } finally {
            System.out.println("Client " + clientId + " disconnected.");
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void writeDataToFile(String data) {
        try (FileWriter writer = new FileWriter(dataFile, true)) {
            writer.write(data + "\n");
        } catch (IOException e) {
            System.err.println("Error writing data to file: " + e.getMessage());
        }
    }
}
