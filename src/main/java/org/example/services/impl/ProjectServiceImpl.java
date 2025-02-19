package org.example.services.impl;

import org.apache.ibatis.session.SqlSession;
import org.example.mapper.ProjectMapper;
import org.example.models.Project;
import org.example.services.ProjectService;
import org.example.utils.MyBatisUtil;

import java.util.List;
import java.util.Optional;

public class ProjectServiceImpl implements ProjectService {

    private final ProjectMapper projectMapper;

    public ProjectServiceImpl() {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            this.projectMapper = session.getMapper(ProjectMapper.class);
        }
    }

    @Override
    public void addProject(Project project) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            projectMapper.insert(project);
            session.commit();
        }
    }

    @Override
    public Optional<Project> getProjectById(Long id) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            return projectMapper.getById(id);
        }
    }

    @Override
    public List<Project> getAllProjects() {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            return projectMapper.getAll();
        }
    }

    @Override
    public void updateProject(Project project) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            projectMapper.update(project);
            session.commit();
        }
    }

    @Override
    public void deleteProject(Long id) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            projectMapper.delete(id);
            session.commit();
        }
    }

    @Override
    public List<Project> getProjectsByTechnology(String technology) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            return projectMapper.getByTechnology(technology);
        }
    }
}