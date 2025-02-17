package org.example.services;

import org.example.models.Consultant;

import java.util.List;

public interface ConsultantService extends Service<Consultant> {

    List<Consultant> getConsultantsByProjectAndManager(Long projectId, Long managerId);
    List<Consultant> getConsultantsByIndustry(String industry);
    List<Consultant> getConsultantsBySalaryRange(Double minSalary, Double maxSalary);
    List<Consultant> getConsultantsByManagerId(Long managerId);
    void updateConsultantSalary(Long id, Double newSalary);
    void updateConsultantIndustry(Long id, String newIndustry);
    void removeConsultantsByManagerId(Long managerId);

}