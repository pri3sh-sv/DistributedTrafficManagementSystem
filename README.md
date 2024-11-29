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

This will generate the JAR files for each module:

centralserver.jar: Contains the server-side logic, WebSocket server.

trafficnode.jar: Contains the sensor node logic that simulates traffic data generation and transmission.

trafficdashboard.jar: Contains the dashboard logic to see the traffic data in CLI.

trafficdashboardweb.jar: Contains the dashboard logic to see the traffic data in UI using Thymeleaf.

Make sure to run the centralserver.jar first and then run trafficnode.jar.

Modules and Usage
1. CentralServer
   The Central Server handles incoming data from traffic nodes, processes it, and makes it available for dashboards.

Run the CentralServer JAR:

java -jar .\CentralServer\target\CentralServer-1.0-SNAPSHOT.jar

2. TrafficNode
   Simulates traffic sensor nodes that generate real-time traffic data.

Run the TrafficNode JAR:

java -jar .\TrafficNode\target\TrafficNode-1.0-SNAPSHOT.jar

You can run multiple instances of trafficnode.jar to simulate multiple sensor nodes.

3. TrafficDashboard

   A command-line interface (CLI) dashboard to visualize traffic data.

Run the TrafficDashboard JAR:

java -jar .\TrafficDashboard\target\TrafficDashboard-1.0-SNAPSHOT.jar

4. TrafficDashboardWeb

   A web-based user interface (UI) dashboard using Thymeleaf to visualize traffic data in real-time.

Run the TrafficDashboardWeb JAR:

java -jar .\TrafficDashboardWeb\target\TrafficDashboardWeb-0.0.1-SNAPSHOT.jar

Accessing the Web Dashboard
Start the CentralServer and TrafficDashboardWeb modules as described above.

Open your web browser and navigate to:

http://localhost:8000

Sign In using the default credentials:

Username: admin
Password: admin
