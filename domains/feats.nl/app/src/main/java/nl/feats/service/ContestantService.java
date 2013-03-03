package nl.feats.service;

import nl.feats.domain.Contestant;
import nl.feats.domain.ContestantRepository;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Service for manipulating a performer
 * User: martin
 * Date: 3/2/13
 * Time: 10:32 PM
 */
@Component
public class ContestantService {

    private final ContestantRepository repository;

    @Inject
    public ContestantService(ContestantRepository repository) {
        this.repository = repository;
    }

    public void addPerformer(Contestant company) {
        repository.save(company);
    }

    public List<Contestant> getAllPerformers() {
        List<Contestant> allContestants = repository.findAll();
        return allContestants == null ? new ArrayList<Contestant>() : allContestants;
    }

    public void updatePerformer(Contestant contestant) {
        repository.save(contestant);
    }

    public Contestant getPerformer(String name)  {
        return repository.findByName(name);
    }

    public void deletePerformer(Contestant contestant) {
        repository.delete(contestant);
    }
}
