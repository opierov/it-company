package org.example.dao;

import org.example.models.Project;
import java.util.List;

public interface ProjectDAO extends BaseDAO<Project> {

    List<Project> getProjectWithClientAndManager(Long projectId);

    List<Project> getByTechnology(String technology);
    List<Project> getByBudgetRange(double minBudget, double maxBudget);
    List<Project> getByDeadline(String deadline);
    List<Project> getByName(String name);

    void updateProjectName(Long id, String newName);
    void updateProjectTechnology(Long id, String newTechnology);

    void deleteByTechnology(String technology);
}