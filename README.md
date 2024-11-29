# Distributed Traffic Management System

## Overview
The Distributed Traffic Management System is a real-time, distributed application designed to manage and visualize traffic data. It consists of three main modules: `CentralServer`, `TrafficNode`, and `TrafficDashboard`. The system utilizes WebSocket communication for real-time data transmission between the server and sensor nodes. Kafka will be integrated for scalability in future versions to handle high traffic data volumes efficiently.

The system simulates traffic sensor nodes that generate traffic data (e.g., vehicle count, speed, temperature) and send this data to the central server, where it is processed and stored. The dashboard module reads this data in real-time and visualizes it to give users insights into traffic conditions.

## Prerequisites
- Java Version: 23
- Maven installed on your system
- Kafka instance (for future scalability)

## Installation
1. Clone the repository or download the source code.
2. Navigate to the root directory of the project.
3. Build the project using the following command:

   ```bash
   mvn clean install
   
This will generate the JAR files for each module
1. `centralserver.jar`: Contains the server-side logic, WebSocket server.
2. `trafficnode.jar`: Contains the sensor node logic that simulates traffic data generation and transmission.
3. `trafficdashboard.jar`: Contains the dashboard logic to see the traffic data.

Make sure to run the `centralserver.jar` first and then run `trafficnode.jar` and `trafficdashboard.jar`. 

