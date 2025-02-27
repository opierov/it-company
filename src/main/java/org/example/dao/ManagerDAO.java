package org.example.dao;

import org.example.models.Manager;
import java.util.List;

public interface ManagerDAO extends BaseDAO<Manager> {

    List<Manager> getManagersByProjectId(Long projectId);

    List<Manager> getBySalaryRange(Double minSalary, Double maxSalary);
    List<Manager> getByIndustry(String industry);
    List<Manager> getBySkills(String skills);

    void updateManagerSalary(Long id, Double newSalary);

    void deleteByIndustry(String industry);
}