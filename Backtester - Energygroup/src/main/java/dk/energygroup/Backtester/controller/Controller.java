package dk.energygroup.Backtester.controller;

import dk.energygroup.Backtester.domain.Graph;
import dk.energygroup.Backtester.domain.Stats;
import dk.energygroup.Backtester.service.GraphService;
import dk.energygroup.Backtester.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:3000")  // Allow requests from React frontend
public class Controller {

    private final GraphService graphService;
    private final StatsService statsService;


    // Constructor for dependency injection
    @Autowired
    public Controller(GraphService graphService, StatsService statsService) {
        this.graphService = graphService;
        this.statsService = statsService;
    }

    @GetMapping("/graph")
    public ResponseEntity<Graph> myEndpoint() {
        Graph graph = graphService.createGraph(); // Call the service method directly
        return ResponseEntity.ok(graph); // Return the name of the created graph
    }

    @GetMapping("/stats")
    public ResponseEntity<Stats> myEndpoint1() {
        Stats stats = statsService.createStats(); // Call the service method directly
        return ResponseEntity.ok(stats); // Return the name of the created graph
    }
}
