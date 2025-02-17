package org.example.dao;

import org.example.models.Consultant;
import java.util.List;

public interface ConsultantDAO extends BaseDAO<Consultant> {

    List<Consultant> getByProjectAndManager(Long projectId, Long managerId);

    List<Consultant> getByIndustry(String industry);
    List<Consultant> getBySalaryRange(double minSalary, double maxSalary);
    List<Consultant> getByManagerId(Long managerId);

    void updateSalary(Long id, double newSalary);
    void updateIndustry(Long id, String newIndustry);

    void deleteByManagerId(Long managerId);
}