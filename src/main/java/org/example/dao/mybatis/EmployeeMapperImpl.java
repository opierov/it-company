package org.example.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.dao.EmployeeDAO;
import org.example.models.Employee;
import org.example.utils.MyBatisUtil;

import java.util.List;
import java.util.Optional;

public class EmployeeMapperImpl implements EmployeeDAO {
    private static final Logger logger = LogManager.getLogger(EmployeeMapperImpl.class);
    //private final SqlSessionFactory sqlSessionFactory;

/*    public EmployeeMapperImpl() {
        this.sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
    }*/

    @Override
    public void insert(Employee employee) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            session.insert("EmployeeMapper.insert", employee);
            session.commit();
        } catch (Exception e) {
            logger.error("Error inserting employee: {}", employee, e);
        }
    }

    @Override
    public List<Employee> getByDepartmentId(Long departmentId) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            return session.selectList("EmployeeMapper.getByDepartmentId", departmentId);
        } catch (Exception e) {
            logger.error("Error retrieving employees for department ID {}", departmentId, e);
            return List.of();
        }
    }

    @Override
    public Optional<Employee> getById(Long id) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            Employee employee = session.selectOne("EmployeeMapper.getById", id);
            return Optional.ofNullable(employee);
        } catch (Exception e) {
            logger.error("Error retrieving employee with ID {}", id, e);
            return Optional.empty();
        }
    }

    @Override
    public List<Employee> getAll() {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            return session.selectList("EmployeeMapper.getAll");
        } catch (Exception e) {
            logger.error("Error retrieving employees from database.", e);
            return List.of();
        }
    }

    @Override
    public List<Employee> getByRole(String role) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            return session.selectList("EmployeeMapper.getByRole", role);
        } catch (Exception e) {
            logger.error("Error retrieving employees by role: {}", role, e);
            return List.of();
        }
    }

    @Override
    public List<Employee> getBySkill(String skill) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            return session.selectList("EmployeeMapper.getBySkill", skill);
        } catch (Exception e) {
            logger.error("Error retrieving employees by skill: {}", skill, e);
            return List.of();
        }
    }

    @Override
    public List<Employee> getBySalaryRange(Double minSalary, Double maxSalary) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            return session.selectList("EmployeeMapper.getBySalaryRange", new Object[]{minSalary, maxSalary});
        } catch (Exception e) {
            logger.error("Error retrieving employees by salary range {} - {}", minSalary, maxSalary, e);
            return List.of();
        }
    }

    @Override
    public void update(Employee employee) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            session.update("EmployeeMapper.update", employee);
            session.commit();
        } catch (Exception e) {
            logger.error("Error updating employee with ID {}", employee.getId(), e);
        }
    }

    @Override
    public void updateSkills(Long id, String skills) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            session.update("EmployeeMapper.updateSkills", new Object[]{id, skills});
            session.commit();
        } catch (Exception e) {
            logger.error("Error updating skills for employee ID {}", id, e);
        }
    }

    @Override
    public void delete(Long id) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            session.delete("EmployeeMapper.delete", id);
            session.commit();
        } catch (Exception e) {
            logger.error("Error deleting employee with ID {}", id, e);
        }
    }

    @Override
    public void deleteBySalaryRange(Double minSalary, Double maxSalary) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            session.delete("EmployeeMapper.deleteBySalaryRange", new Object[]{minSalary, maxSalary});
            session.commit();
        } catch (Exception e) {
            logger.error("Error deleting employees with salary between {} and {}", minSalary, maxSalary, e);
        }
    }
}
