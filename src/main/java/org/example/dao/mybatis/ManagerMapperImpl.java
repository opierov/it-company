package org.example.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.dao.ManagerDAO;
import org.example.models.Manager;
import org.example.utils.MyBatisUtil;

import java.util.List;
import java.util.Optional;

public class ManagerMapperImpl implements ManagerDAO {
    private static final Logger logger = LogManager.getLogger(ManagerMapperImpl.class);
    private final SqlSessionFactory sqlSessionFactory;

    public ManagerMapperImpl() {
        this.sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
    }

    @Override
    public void insert(Manager manager) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            session.getMapper(ManagerDAO.class).insert(manager);
            logger.info("Manager inserted successfully: {}", manager.getFirstName());
        } catch (Exception e) {
            logger.error("Error inserting manager", e);
        }
    }

    @Override
    public List<Manager> getManagersByProjectId(Long projectId) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            return session.getMapper(ManagerDAO.class).getManagersByProjectId(projectId);
        } catch (Exception e) {
            logger.error("Error retrieving managers by project", e);
            return List.of();
        }
    }

    @Override
    public Optional<Manager> getById(Long id) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            return session.getMapper(ManagerDAO.class).getById(id);
        } catch (Exception e) {
            logger.error("Error retrieving manager by id {}", id, e);
            return Optional.empty();
        }
    }

    @Override
    public List<Manager> getByIndustry(String industry) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            return session.getMapper(ManagerDAO.class).getByIndustry(industry);
        } catch (Exception e) {
            logger.error("Error retrieving manager by industry: {}", industry, e);
            return List.of();
        }
    }

    @Override
    public List<Manager> getAll() {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            return session.getMapper(ManagerDAO.class).getAll();
        } catch (Exception e) {
            logger.error("Error retrieving all managers", e);
            return List.of();
        }
    }

    @Override
    public List<Manager> getBySalaryRange(Double minSalary, Double maxSalary) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            return session.getMapper(ManagerDAO.class).getBySalaryRange(minSalary, maxSalary);
        } catch (Exception e) {
            logger.error("Error retrieving managers by salary range", e);
            return List.of();
        }
    }

    @Override
    public List<Manager> getBySkills(String skills) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            return session.getMapper(ManagerDAO.class).getBySkills(skills);
        } catch (Exception e) {
            logger.error("Error retrieving managers by skill", e);
            return List.of();
        }
    }

    @Override
    public void update(Manager manager) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            session.getMapper(ManagerDAO.class).update(manager);
            logger.info("Manager updated successfully: {}", manager.getId());
        } catch (Exception e) {
            logger.error("Error updating manager", e);
        }
    }

    @Override
    public void updateManagerSalary(Long id, Double newSalary) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            session.getMapper(ManagerDAO.class).updateManagerSalary(id, newSalary);
            logger.info("Manager salary updated successfully.");
        } catch (Exception e) {
            logger.error("Error updating manager salary", e);
        }
    }

    @Override
    public void delete(Long id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.getMapper(ManagerDAO.class).delete(id);
            logger.info("Manager deleted successfully.");
        } catch (Exception e) {
            logger.error("Error deleting manager", e);
        }
    }

    @Override
    public void deleteByIndustry(String industry) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.getMapper(ManagerDAO.class).deleteByIndustry(industry);
            logger.info("Managers deleted with industry");
        } catch (Exception e) {
            logger.error("Error deleting managers by industry", e);
        }
    }
}
