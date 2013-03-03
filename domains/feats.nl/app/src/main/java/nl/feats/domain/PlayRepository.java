package nl.feats.domain;

/**
 * The repository that can be used to retrieve and store a play
 * User: martin
 * Date: 3/2/13
 * Time: 8:39 PM
 */
public interface PlayRepository {

    public void save(Play play);

    public void delete(Play play);

    public Play findByName(String name);
}
