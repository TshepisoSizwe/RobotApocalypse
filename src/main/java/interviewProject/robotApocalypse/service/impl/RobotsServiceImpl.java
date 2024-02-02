package interviewProject.robotApocalypse.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import interviewProject.robotApocalypse.entity.Robots;
import interviewProject.robotApocalypse.service.RobotService;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import java.util.Collections;

@Service
public class RobotsServiceImpl implements RobotService {

    @Override
    public String fetchAndDisplaySortedRobots(String robotUrl) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            URL url = new URL(robotUrl);
            Robots[] robots = objectMapper.readValue(url, Robots[].class);
            List<Robots> robotList = Arrays.asList(robots);
            robotList.sort(Comparator.comparing(Robots::getCategory));

            Collections.sort(robotList, new Comparator<Robots>() {
                @Override
                public int compare(Robots robot1, Robots robot2) {
                    return robot1.getCategory().compareTo(robot2.getCategory());
                }
            });


            StringBuilder display = new StringBuilder();
            for (Robots robot : robotList) {
                display.append("Model: ").append(robot.getModel()).append("\n");
                display.append("Serial Number: ").append(robot.getSerialNumber()).append("\n");
                display.append("Manufactured Date: ").append(robot.getManufacturedDate()).append("\n");
                display.append("Category: ").append(robot.getCategory()).append("\n\n");
            }
            return display.toString();
        } catch (Exception e) {
            // Handle the exception appropriately
            return "Error fetching and displaying robots: " + e.getMessage();
        }
    }
}
