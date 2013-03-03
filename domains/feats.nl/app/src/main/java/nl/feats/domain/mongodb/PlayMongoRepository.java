package nl.feats.domain.mongodb;

import nl.feats.domain.Play;
import nl.feats.domain.PlayRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

/**
 * implementation of Play Repository
 * User: martin
 * Date: 3/2/13
 * Time: 9:50 PM
 */
@Repository
public class PlayMongoRepository implements PlayRepository {

    private final MongoTemplate template;

    @Inject
    public PlayMongoRepository(MongoTemplate template) {
        this.template = template;
    }

    @Override
    public void save(Play play) {
        template.save(play);
    }

    @Override
    public void delete(Play play) {
        template.remove(play);
    }

    @Override
    public Play findByName(String name) {
        return template.findOne(Query.query(Criteria.where("name").is(name)), Play.class);
    }
}

