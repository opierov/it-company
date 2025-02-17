package org.example.services;

import org.example.models.Project;
import java.util.List;

public interface ProjectService extends Service<Project> {

    List<Project> getProjectWithClientAndManager(Long projectId);
    List<Project> getProjectsByTechnology(String technology);
    List<Project> getProjectsByBudgetRange(Double minBudget, Double maxBudget);
    List<Project> getProjectsByDeadline(String deadline);
    List<Project> getProjectsByName(String name);
    void updateProjectName(Long id, String newName);
    void updateProjectTechnology(Long id, String newTechnology);
    void deleteProjectsByTechnology(String technology);

}
