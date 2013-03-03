package nl.feats.domain.mongodb;

import nl.feats.domain.User;
import nl.feats.domain.UserRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

/**
 * Mongo DB based implementation of a UserRepository
 * User: martin
 * Date: 3/2/13
 * Time: 8:03 PM
 */
@Repository
public class UserMongoRepository implements UserRepository {

    private final MongoTemplate template;

    @Inject
    public UserMongoRepository(MongoTemplate template) {
        this.template = template;
    }


    @Override
    public User findByEmailAddress(String emailAddress) {
        return template.findOne(Query.query(Criteria.where("emailAddress").is(emailAddress)), User.class);
    }

    @Override
    public List<User> findAll() {
        return template.findAll(User.class);
    }

    @Override
    public List<User> findByGroup(String group) {
        return template.find(Query.query(Criteria.where("group").is(group)), User.class);
    }

    @Override
    public void save(User user) {
        template.save(user);
    }

    @Override
    public void delete(User user) {
        template.remove(user);
    }
}
