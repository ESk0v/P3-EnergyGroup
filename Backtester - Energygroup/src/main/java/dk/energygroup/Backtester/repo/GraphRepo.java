package dk.energygroup.Backtester.repo;

import dk.energygroup.Backtester.domain.Graph;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@EnableMongoRepositories
@Repository
public interface GraphRepo extends MongoRepository<Graph, String> {

    @Query("{timeframe:'?0'}")
    Graph findItemByTimeframe(String timeframe);
}