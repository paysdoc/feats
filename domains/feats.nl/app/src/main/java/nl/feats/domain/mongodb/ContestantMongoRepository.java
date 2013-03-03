package nl.feats.domain.mongodb;

import nl.feats.domain.Contestant;
import nl.feats.domain.ContestantRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

/**
 * Implementation of ContestantRepository
 * User: martin
 * Date: 3/2/13
 * Time: 8:36 PM
 */
@Repository
public class ContestantMongoRepository implements ContestantRepository {

    private final MongoTemplate template;

    @Inject
    public ContestantMongoRepository(MongoTemplate template) {
        this.template = template;
    }

    @Override
    public void delete(Contestant company) {
        template.remove(company);
    }

    @Override
    public void save(Contestant company) {
        template.save(company);
    }

    @Override
    public Contestant findByName(String name) {
        return template.findOne(Query.query(Criteria.where("name").is(name)), Contestant.class);
    }

    @Override
    public List<Contestant> findAll() {
        return template.findAll(Contestant.class);
    }
}
