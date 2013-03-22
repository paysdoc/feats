package nl.feats.service;

import nl.feats.domain.Contestant;
import nl.feats.domain.ContestantRepository;
import nl.feats.domain.StageManagement;
import nl.feats.domain.StageManagementRepository;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * CRUD service for the stage management data
 * User: martin
 * Date: 3/10/13
 * Time: 9:58 PM
 */
@Component
public class StageManagementService {

    private final StageManagementRepository repository;

    @Inject
    public StageManagementService(StageManagementRepository repository) {
        this.repository = repository;
    }

    public void addStageManagement(StageManagement stageManagement) {
        repository.save(stageManagement);
    }

    public List<StageManagement> getAllStageManagements() {
        List<StageManagement> allStageManagements = repository.findAll();
        return allStageManagements == null ? new ArrayList<StageManagement>() : allStageManagements;
    }

    public void updateStageManagement (StageManagement stageManagement) {
        repository.save(stageManagement);
    }

    public StageManagement getStageManagement(Contestant contestant)  {
        return repository.findByContestant(contestant);
    }

    public void deleteStageManagement(StageManagement stageManagement) {
        repository.delete(stageManagement);
    }
}
