package dk.energygroup.Backtester.service;

import dk.energygroup.Backtester.repo.StatsRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import dk.energygroup.Backtester.domain.Stats;

@Service
public class StatsService {

    private final StatsRepo statsRepo;
    private static final Logger logger = LoggerFactory.getLogger(StatsService.class);

    public StatsService(StatsRepo statsRepo) {
        this.statsRepo = statsRepo;
    }

    public Stats createStats() {
        logger.info("Creating new stats...");
        Stats stats = new Stats((int)(Math.random()*10)+1, (int)(Math.random()*10)+1,(int)(Math.random()*10)+1,(int)(Math.random()*10)+1);

        try {
            Stats savedStats = statsRepo.save(stats);
            logger.info("Data created with PnL: {}", savedStats.getPnL()); // Log the created ID
            return savedStats;
        } catch (Exception e) {
            logger.error("Error creating stats", e);
            return null; // or throw a custom exception
        }
    }


}
