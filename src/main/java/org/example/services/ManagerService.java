package org.example.services;

import org.example.models.Manager;

import java.util.List;

public interface ManagerService extends Service<Manager> {

    List<Manager> getManagersByProjectId(Long projectId);
    List<Manager> getManagersBySalaryRange(Double minSalary, Double maxSalary);
    List<Manager> getManagersByIndustry(String industry);
    List<Manager> getManagersBySkills(String skills);
    void updateManagerSalary(Long id, Double newSalary);
    void removeManagersByIndustry(String industry);
}
