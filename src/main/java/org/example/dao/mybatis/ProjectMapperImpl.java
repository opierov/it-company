package org.example.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.dao.ProjectDAO;
import org.example.models.Project;
import org.example.utils.MyBatisUtil;

import java.util.List;
import java.util.Optional;

public class ProjectMapperImpl implements ProjectDAO {
    private static final Logger logger = LogManager.getLogger(ProjectMapperImpl.class);
    private final SqlSessionFactory sqlSessionFactory;

    public ProjectMapperImpl() {
        this.sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
    }

    @Override
    public void insert(Project project) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            session.insert("ProjectMapper.insert", project);
        } catch (Exception e) {
            logger.error("Error inserting project: ", e);
        }
    }

    @Override
    public List<Project> getProjectWithClientAndManager(Long projectId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("ProjectMapper.getProjectWithClientAndManager", projectId);
        } catch (Exception e) {
            logger.error("Error fetching project with client and manager", e);
            return List.of();
        }
    }

    @Override
    public List<Project> getAll() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("ProjectMapper.getAll");
        } catch (Exception e) {
            logger.error("Error fetching all projects: ", e);
            return List.of();
        }
    }

    @Override
    public Optional<Project> getById(Long id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return Optional.ofNullable(session.selectOne("ProjectMapper.getById", id));
        } catch (Exception e) {
            logger.error("Error fetching project by id", e);
            return Optional.empty();
        }
    }

    @Override
    public List<Project> getByTechnology(String technology) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("ProjectMapper.getByTechnology", technology);
        } catch (Exception e) {
            logger.error("Error fetching projects by technology: ", e);
            return List.of();
        }
    }

    @Override
    public List<Project> getByBudgetRange(Double minBudget, Double maxBudget) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("ProjectMapper.getByBudgetRange", new Object[]{minBudget, maxBudget});
        } catch (Exception e) {
            logger.error("Error fetching projects by budget range: ", e);
            return List.of();
        }
    }

    @Override
    public List<Project> getByDeadline(String deadline) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("ProjectMapper.getByDeadline", new Object[]{deadline});
        } catch (Exception e) {
            logger.error("Error fetching projects by deadline: ", e);
            return List.of();
        }
    }

    @Override
    public List<Project> getByName(String name) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("ProjectMapper.getByName", new Object[]{name});
        } catch (Exception e) {
            logger.error("Error fetching projects by name: ", e);
            return List.of();
        }
    }

    @Override
    public void update(Project project) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            session.update("ProjectMapper.update", project);
        } catch (Exception e) {
            logger.error("Error updating project with ID {}", project.getId(), e);
        }
    }

    @Override
    public void updateProjectName(Long id, String newName) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            session.update("ProjectMapper.updateProjectName", new Object[]{id, newName});
        } catch (Exception e) {
            logger.error("Error updating project name: ", e);
        }
    }

    @Override
    public void updateProjectTechnology(Long id, String newTechnology) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            session.update("ProjectMapper.updateProjectTechnology", new Object[]{id, newTechnology});
        } catch (Exception e) {
            logger.error("Error updating project technology: ", e);
        }
    }

    @Override
    public void delete(Long id) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            session.delete("ProjectMapper.delete", id);
        } catch (Exception e) {
            logger.error("Error deleting project: ", e);
        }
    }

    @Override
    public void deleteByTechnology(String technology) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            session.delete("ProjectMapper.deleteByTechnology", technology);
        } catch (Exception e) {
            logger.error("Error deleting projects by technology: ", e);
        }
    }
}
