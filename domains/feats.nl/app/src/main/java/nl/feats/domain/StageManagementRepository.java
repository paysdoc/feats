package nl.feats.domain;

import java.util.List;

/**
 * Repository for a StageManagement object
 * User: martin
 * Date: 3/10/13
 * Time: 10:00 PM
 */
public interface StageManagementRepository {

    public void delete(StageManagement stageManagement);

    public void save(StageManagement stageManagement);

    public StageManagement findByContestant(Contestant contestant);

    public List<StageManagement> findAll();
}
