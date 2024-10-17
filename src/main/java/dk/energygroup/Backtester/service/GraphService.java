package dk.energygroup.Backtester.service;

import dk.energygroup.Backtester.domain.Graph;
import dk.energygroup.Backtester.repo.GraphRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GraphService {

    private final GraphRepo graphRepo;
    private static final Logger logger = LoggerFactory.getLogger(GraphService.class);

    public GraphService(GraphRepo graphRepo) {
        this.graphRepo = graphRepo;
    }

    // Save graph
    public Graph createGraph() {
        logger.info("Data creation started...");
        Graph graph = new Graph(null, "2 January", "15 PowerHour"); // Use null for auto-generated ID

        try {
            Graph savedGraph = graphRepo.save(graph);
            logger.info("Data created with ID: {}", savedGraph.getId()); // Log the created ID
            return savedGraph;
        } catch (Exception e) {
            logger.error("Error creating graph", e);
            return null; // or throw a custom exception
        }
    }

    // Get graph by Timeframe
    public String getGraphByTimeframe(String timeframe) {
        System.out.println("Getting item by name: " + timeframe);
        Graph graph = graphRepo.findItemByTimeframe(timeframe); // Use instance method
        System.out.println(graph.getTimeframe());
        return graph.getPowerHour() + " " + graph.getTimeframe();
    }
}
