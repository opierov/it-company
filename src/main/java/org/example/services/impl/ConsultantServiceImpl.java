package org.example.services.impl;

import org.apache.ibatis.session.SqlSession;
import org.example.mapper.ConsultantMapper;
import org.example.models.Consultant;
import org.example.services.ConsultantService;
import org.example.utils.MyBatisUtil;

import java.util.List;
import java.util.Optional;

public class ConsultantServiceImpl implements ConsultantService {

    private final ConsultantMapper consultantMapper;

    public ConsultantServiceImpl() {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            this.consultantMapper = session.getMapper(ConsultantMapper.class);
        }
    }

    @Override
    public void addConsultant(Consultant consultant) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            consultantMapper.insert(consultant);
            session.commit();
        }
    }

    @Override
    public Optional<Consultant> getConsultantById(Long id) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            return consultantMapper.getById(id);
        }
    }

    @Override
    public List<Consultant> getAllConsultants() {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            return consultantMapper.getAll();
        }
    }

    @Override
    public void updateConsultant(Consultant consultant) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            consultantMapper.update(consultant);
            session.commit();
        }
    }

    @Override
    public void deleteConsultant(Long id) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            consultantMapper.delete(id);
            session.commit();
        }
    }

    @Override
    public List<Consultant> getConsultantsByIndustry(String industry) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            return consultantMapper.getByIndustry(industry);
        }
    }
}