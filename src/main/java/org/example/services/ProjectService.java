package org.example.services;

import org.example.models.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    void addProject(Project project);
    Optional<Project> getProjectById(Long id);
    List<Project> getAllProjects();
    void updateProject(Project project);
    void deleteProject(Long id);
    List<Project> getProjectsByTechnology(String technology);

}
