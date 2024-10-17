package dk.energygroup.Backtester.repo;

import dk.energygroup.Backtester.domain.Stats;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@EnableMongoRepositories
@Repository
public interface StatsRepo extends MongoRepository<Stats, String>{

    @Query("{PnL :'?0'}")
    Stats findByItemPnL(String PnL);
}
