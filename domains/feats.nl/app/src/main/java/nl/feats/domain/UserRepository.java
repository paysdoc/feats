package nl.feats.domain;

import java.util.List;

/**
 * The repository that can be used to retrieve and store a user
 * User: martin
 * Date: 3/2/13
 * Time: 7:59 PM
 */
public interface UserRepository {

    public User findByEmailAddress(String emailAddress);

    public List<User> findAll();

    public List<User> findByGroup(String group);

    public void save(User user);

    public void delete(User user);
}
