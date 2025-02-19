package org.example.services;

import org.example.models.Consultant;

import java.util.List;
import java.util.Optional;

public interface ConsultantService {
    void addConsultant(Consultant consultant);
    Optional<Consultant> getConsultantById(Long id);
    List<Consultant> getAllConsultants();
    void updateConsultant(Consultant consultant);
    void deleteConsultant(Long id);
    List<Consultant> getConsultantsByIndustry(String industry);
}