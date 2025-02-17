package org.example.services.impl;

import org.example.dao.ProjectDAO;
import org.example.dao.impl.ProjectDAOImpl;
import org.example.models.Project;
import org.example.services.ProjectService;

import java.util.List;
import java.util.Optional;

public class ProjectServiceImpl implements ProjectService {

    private final ProjectDAO projectDAO;

    public ProjectServiceImpl() {
        this.projectDAO = new ProjectDAOImpl();
    }

    @Override
    public void add(Project project) {
        projectDAO.insert(project);
    }

    @Override
    public Optional<Project> getById(Long id) {
        return projectDAO.getById(id);
    }

    @Override
    public List<Project> getAll() {
        return projectDAO.getAll();
    }

    @Override
    public void update(Project project) {
        projectDAO.update(project);
    }

    @Override
    public void delete(Long id) {
        projectDAO.delete(id);
    }

    @Override
    public List<Project> getProjectWithClientAndManager(Long projectId) {
        return projectDAO.getProjectWithClientAndManager(projectId);
    }

    @Override
    public List<Project> getProjectsByTechnology(String technology) {
        return projectDAO.getByTechnology(technology);
    }

    @Override
    public List<Project> getProjectsByBudgetRange(Double minBudget, Double maxBudget) {
        return projectDAO.getByBudgetRange(minBudget, maxBudget);
    }

    @Override
    public List<Project> getProjectsByDeadline(String deadline) {
        return projectDAO.getByDeadline(deadline);
    }

    @Override
    public List<Project> getProjectsByName(String name) {
        return projectDAO.getByName(name);
    }

    @Override
    public void updateProjectName(Long id, String newName) {
        projectDAO.updateProjectName(id, newName);
    }

    @Override
    public void updateProjectTechnology(Long id, String newTechnology) {
        projectDAO.updateProjectTechnology(id, newTechnology);
    }

    @Override
    public void deleteProjectsByTechnology(String technology) {
        projectDAO.deleteByTechnology(technology);
    }
}
