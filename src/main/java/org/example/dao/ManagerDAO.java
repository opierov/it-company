package org.example.dao;

import org.example.models.Manager;
import java.util.List;

public interface ManagerDAO extends BaseDAO<Manager> {

    List<Manager> getManagersByProjectId(Long projectId);

    List<Manager> getBySalaryRange(double minSalary, double maxSalary);
    List<Manager> getByIndustry(String industry);
    List<Manager> getBySkills(String skills);

    void updateManagerSalary(Long id, double newSalary);

    void deleteByIndustry(String industry);
}