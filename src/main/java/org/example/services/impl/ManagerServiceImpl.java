package org.example.services.impl;

import org.example.dao.ManagerDAO;
import org.example.dao.impl.ManagerDAOImpl;
import org.example.models.Manager;
import org.example.services.ManagerService;

import java.util.List;
import java.util.Optional;

public class ManagerServiceImpl implements ManagerService {

    private final ManagerDAO managerDAO;

    public ManagerServiceImpl() {
        this.managerDAO = new ManagerDAOImpl(); // Inject DAO here
    }

    @Override
    public void add(Manager manager) {
        managerDAO.insert(manager);
    }

    @Override
    public Optional<Manager> getById(Long id) {
        return managerDAO.getById(id);
    }

    @Override
    public List<Manager> getAll() {
        return managerDAO.getAll();
    }

    @Override
    public void update(Manager manager) {
        managerDAO.update(manager);
    }

    @Override
    public void delete(Long id) {
        managerDAO.delete(id);
    }

    @Override
    public List<Manager> getManagersByProjectId(Long projectId) {
        return managerDAO.getManagersByProjectId(projectId);
    }

    @Override
    public List<Manager> getManagersBySalaryRange(Double minSalary, Double maxSalary) {
        return managerDAO.getBySalaryRange(minSalary, maxSalary);
    }

    @Override
    public List<Manager> getManagersByIndustry(String industry) {
        return managerDAO.getByIndustry(industry);
    }

    @Override
    public List<Manager> getManagersBySkills(String skills) {
        return managerDAO.getBySkills(skills);
    }

    @Override
    public void updateManagerSalary(Long id, Double newSalary) {
        managerDAO.updateManagerSalary(id, newSalary);
    }

    @Override
    public void removeManagersByIndustry(String industry) {
        managerDAO.deleteByIndustry(industry);
    }
}
