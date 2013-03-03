package nl.feats.domain;

import java.util.List;

/**
 * The repository that can be used to retrieve and store a theatre company
 * User: martin
 * Date: 3/2/13
 * Time: 8:31 PM
 */
public interface ContestantRepository {

    public void delete(Contestant company);

    public void save(Contestant company);

    public Contestant findByName(String name);

    public List<Contestant> findAll();
}
