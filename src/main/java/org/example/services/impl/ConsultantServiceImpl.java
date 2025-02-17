package org.example.services.impl;

import org.example.dao.ConsultantDAO;
import org.example.dao.impl.ConsultantDAOImpl;
import org.example.models.Consultant;
import org.example.services.ConsultantService;

import java.util.List;
import java.util.Optional;

public class ConsultantServiceImpl implements ConsultantService {

    private final ConsultantDAO consultantDAO;

    public ConsultantServiceImpl() {
        this.consultantDAO = new ConsultantDAOImpl();
    }

    @Override
    public void add(Consultant consultant) {
        consultantDAO.insert(consultant);
    }

    @Override
    public Optional<Consultant> getById(Long id) {
        return consultantDAO.getById(id);
    }

    @Override
    public List<Consultant> getAll() {
        return consultantDAO.getAll();
    }

    @Override
    public void update(Consultant consultant) {
        consultantDAO.update(consultant);
    }

    @Override
    public void delete(Long id) {
        consultantDAO.delete(id);
    }

    @Override
    public List<Consultant> getConsultantsByProjectAndManager(Long projectId, Long managerId) {
        return consultantDAO.getByProjectAndManager(projectId, managerId);
    }

    @Override
    public List<Consultant> getConsultantsByIndustry(String industry) {
        return consultantDAO.getByIndustry(industry);
    }

    @Override
    public List<Consultant> getConsultantsBySalaryRange(Double minSalary, Double maxSalary) {
        return consultantDAO.getBySalaryRange(minSalary, maxSalary);
    }

    @Override
    public List<Consultant> getConsultantsByManagerId(Long managerId) {
        return consultantDAO.getByManagerId(managerId);
    }

    @Override
    public void updateConsultantSalary(Long id, Double newSalary) {
        consultantDAO.updateSalary(id, newSalary);
    }

    @Override
    public void updateConsultantIndustry(Long id, String newIndustry) {
        consultantDAO.updateIndustry(id, newIndustry);
    }

    @Override
    public void removeConsultantsByManagerId(Long managerId) {
        consultantDAO.deleteByManagerId(managerId);
    }
}