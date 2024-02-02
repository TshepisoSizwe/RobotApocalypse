package interviewProject.robotApocalypse.controller;

import interviewProject.robotApocalypse.service.impl.RobotsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/robots")
public class robotController {

    @Autowired
    private RobotsServiceImpl robotsServiceImpl;

    private static final String SUCCESS = "Success";

    @GetMapping("/")
    public String getDefaultContext()
    {
        return SUCCESS;
    }

    @GetMapping("/fetch-and-display-sorted")
    public String fetchAndDisplaySortedRobots(@RequestParam String robotUrl) {
        return robotsServiceImpl.fetchAndDisplaySortedRobots(robotUrl);
    }
}
