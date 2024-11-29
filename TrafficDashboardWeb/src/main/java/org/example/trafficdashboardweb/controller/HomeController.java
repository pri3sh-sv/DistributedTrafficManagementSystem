package org.example.trafficdashboardweb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    private static final String DATA_FILE = "trafficData.txt";
    private static long lastReadPosition = 0;
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    private static final List<String> allDataLines = new ArrayList<>();


    @GetMapping("/signin")
    public String signin() {
        return "signin"; // Custom login page
    }

    @GetMapping("/")
    public String showDashboard(Model model) {
        logger.info("Handling request for '/'");
        readDataFromFile();
        model.addAttribute("dataLines", allDataLines);
        return "Dashboard";
    }

    private void readDataFromFile() {
        File file = new File(DATA_FILE);
        if (!file.exists()) {
            logger.warn("Data file does not exist.");
            return;
        }

        try (RandomAccessFile reader = new RandomAccessFile(file, "r")) {
            reader.seek(lastReadPosition);

            String line;
            while ((line = reader.readLine()) != null) {
                allDataLines.add(line);
            }
            lastReadPosition = reader.getFilePointer();

        } catch (IOException e) {
            logger.error("Error reading data: " + e.getMessage());
            allDataLines.add("Error reading data: " + e.getMessage());
        }
    }
}


