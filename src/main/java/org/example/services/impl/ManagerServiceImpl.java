package org.example.services.impl;

import org.apache.ibatis.session.SqlSession;
import org.example.mapper.ManagerMapper;
import org.example.models.Manager;
import org.example.services.ManagerService;
import org.example.utils.MyBatisUtil;

import java.util.List;
import java.util.Optional;

public class ManagerServiceImpl implements ManagerService {

    private final ManagerMapper managerMapper;

    public ManagerServiceImpl() {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            this.managerMapper = session.getMapper(ManagerMapper.class);
        }
    }

    @Override
    public void addManager(Manager manager) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            managerMapper.insert(manager);
            session.commit();
        }
    }

    @Override
    public Optional<Manager> getManagerById(Long id) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            return managerMapper.getById(id);
        }
    }

    @Override
    public List<Manager> getAllManagers() {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            return managerMapper.getAll();
        }
    }

    @Override
    public void updateManager(Manager manager) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            managerMapper.update(manager);
            session.commit();
        }
    }

    @Override
    public void deleteManager(Long id) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            managerMapper.delete(id);
            session.commit();
        }
    }

    @Override
    public List<Manager> getManagersByIndustry(String industry) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            return managerMapper.getByIndustry(industry);
        }
    }
}