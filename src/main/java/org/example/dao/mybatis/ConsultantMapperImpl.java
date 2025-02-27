package org.example.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.dao.ConsultantDAO;
import org.example.models.Consultant;
import org.example.utils.MyBatisUtil;

import java.util.List;
import java.util.Optional;

public class ConsultantMapperImpl implements ConsultantDAO {
    private static final Logger logger = LogManager.getLogger(ConsultantMapperImpl.class);
    private final SqlSessionFactory sqlSessionFactory;

    public ConsultantMapperImpl() {
        this.sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
    }

    @Override
    public void insert(Consultant consultant) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            session.getMapper(ConsultantDAO.class).insert(consultant);
            logger.info("Consultant inserted successfully: {}", consultant.getFirstName());
        } catch (Exception e) {
            logger.error("Error inserting consultant", e);
        }
    }

    @Override
    public List<Consultant> getByProjectAndManager(Long projectId, Long managerId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.getMapper(ConsultantDAO.class).getByProjectAndManager(projectId, managerId);
        } catch (Exception e) {
            logger.error("Error retrieving consultants by project and manager", e);
            return List.of();
        }
    }

    @Override
    public Optional<Consultant> getById(Long id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.getMapper(ConsultantDAO.class).getById(id);
        } catch (Exception e) {
            logger.error("Error retrieving consultant by id {}", id, e);
            return Optional.empty();
        }
    }

    @Override
    public List<Consultant> getAll() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.getMapper(ConsultantDAO.class).getAll();
        } catch (Exception e) {
            logger.error("Error retrieving all consultants", e);
            return List.of();
        }
    }

    @Override
    public List<Consultant> getByIndustry(String industry) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.getMapper(ConsultantDAO.class).getByIndustry(industry);
        } catch (Exception e) {
            logger.error("Error retrieving consultants by industry: {}", industry, e);
            return List.of();
        }
    }

    @Override
    public List<Consultant> getBySalaryRange(Double minSalary, Double maxSalary) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.getMapper(ConsultantDAO.class).getBySalaryRange(minSalary, maxSalary);
        } catch (Exception e) {
            logger.error("Error retrieving consultants by salary range", e);
            return List.of();
        }
    }

    @Override
    public List<Consultant> getByManagerId(Long managerId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.getMapper(ConsultantDAO.class).getByManagerId(managerId);
        } catch (Exception e) {
            logger.error("Error retrieving consultants by manager id", e);
            return List.of();
        }
    }

    @Override
    public void update(Consultant consultant) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            session.getMapper(ConsultantDAO.class).update(consultant);
            logger.info("Consultant updated successfully: {}", consultant.getId());
        } catch (Exception e) {
            logger.error("Error updating consultant", e);
        }
    }

    @Override
    public void updateSalary(Long id, Double newSalary) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            session.getMapper(ConsultantDAO.class).updateSalary(id, newSalary);
            logger.info("Consultant salary updated successfully.");
        } catch (Exception e) {
            logger.error("Error updating consultant salary", e);
        }
    }

    @Override
    public void updateIndustry(Long id, String newIndustry) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            session.getMapper(ConsultantDAO.class).updateIndustry(id, newIndustry);
            logger.info("Consultant industry updated successfully.");
        } catch (Exception e) {
            logger.error("Error updating consultant industry", e);
        }
    }

    @Override
    public void delete(Long id) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            session.getMapper(ConsultantDAO.class).delete(id);
            logger.info("Consultant deleted successfully.");
        } catch (Exception e) {
            logger.error("Error deleting consultant", e);
        }
    }

    @Override
    public void deleteByManagerId(Long managerId) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            session.getMapper(ConsultantDAO.class).deleteByManagerId(managerId);
            logger.info("Consultants with manager ID {} deleted successfully.", managerId);
        } catch (Exception e) {
            logger.error("Error deleting consultants by manager id", e);
        }
    }
}
