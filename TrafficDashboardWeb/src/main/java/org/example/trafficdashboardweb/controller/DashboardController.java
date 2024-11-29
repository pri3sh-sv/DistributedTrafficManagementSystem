//package org.example.trafficdashboardweb.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.File;
//import java.io.IOException;
//import java.io.RandomAccessFile;
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//public class DashboardController {
//    private static final String DATA_FILE = "trafficData.txt";
//    private static long lastReadPosition = 0;
//    private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);
//
//    // Persistent list to store all read data lines
//    private static final List<String> allDataLines = new ArrayList<>();
//
//    @GetMapping("/dashboard")
//    public String showDashboard(Model model) {
//        logger.info("Handling request for '/'");
//        readDataFromFile();  // Only updates if new data exists
//        model.addAttribute("dataLines", allDataLines);  // Pass all accumulated data
//        return "Dashboard";  // Ensure the template is named Dashboard.html
//    }
//
//    private void readDataFromFile() {
//        File file = new File(DATA_FILE);
//        if (!file.exists()) {
//            logger.warn("Data file does not exist.");
//            return;
//        }
//
//        try (RandomAccessFile reader = new RandomAccessFile(file, "r")) {
//            reader.seek(lastReadPosition);  // Start reading from the last read position
//
//            String line;
//            while ((line = reader.readLine()) != null) {
//                allDataLines.add(line);  // Append new lines to the persistent list
//            }
//            lastReadPosition = reader.getFilePointer();  // Update the position pointer
//
//        } catch (IOException e) {
//            logger.error("Error reading data: " + e.getMessage());
//            allDataLines.add("Error reading data: " + e.getMessage());
//        }
//    }
//}
