/*
package org.example.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.dao.EmployeeDAO;
import org.example.models.Employee;
import org.example.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeDAOImpl implements EmployeeDAO {
    private static final Logger logger = LogManager.getLogger(EmployeeDAOImpl.class);
    private final Connection connection;

    public EmployeeDAOImpl() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    // 1. Insert operation
    @Override
    public void insert(Employee employee) {
        String sql = "INSERT INTO employees (first_name, last_name, role, salary, skills) " +
                "VALUES (?, ?, ?, ?, ?) ";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, employee.getFirstName());
            stmt.setString(2, employee.getLastName());
            stmt.setString(3, employee.getRole());
            stmt.setDouble(4, employee.getSalary());
            stmt.setString(5, employee.getSkills());
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error inserting employee: {}", employee, e);
        }
    }

    // 2. Select with two join statements
    @Override
    public List<Employee> getByDepartmentId(Long departmentId) {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT e.* FROM employees e " +
                "JOIN teams t ON e.id = t.employees_id " +
                "JOIN departments d ON t.id = d.teams_id " +
                "WHERE d.id = ? ";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, departmentId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                employees.add(mapResultSetToEmployee(rs));
            }
        } catch (SQLException e) {
            logger.error("Error retrieving employees for department ID {}", departmentId, e);
        }
        return employees;
    }

    // 3. Five select operations
    @Override
    public Optional<Employee> getById(Long id) {
        String sql = "SELECT * FROM employees WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Employee employee = mapResultSetToEmployee(rs);
                return Optional.of(employee);
            }
        } catch (SQLException e) {
            logger.error("Error retrieving employee with ID {}", id, e);
        }
        return Optional.empty();
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                employees.add(mapResultSetToEmployee(rs));
            }
        } catch (SQLException e) {
            logger.error("Error retrieving employees from database.", e);
        }
        return employees;
    }

    @Override
    public List<Employee> getByRole(String role) {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees WHERE role = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, role);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                employees.add(mapResultSetToEmployee(rs));
            }
        } catch (SQLException e) {
            logger.error("Error retrieving employees by role: {}", role, e);
        }
        return employees;
    }

    @Override
    public List<Employee> getBySkill(String skill) {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees WHERE skills LIKE ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, "%" + skill + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                employees.add(mapResultSetToEmployee(rs));
            }
        } catch (SQLException e) {
            logger.error("Error retrieving employees by skill: {}", skill, e);
        }
        return employees;
    }

    @Override
    public List<Employee> getBySalaryRange(Double minSalary, Double maxSalary) {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees WHERE salary BETWEEN ? AND ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, minSalary);
            stmt.setDouble(2, maxSalary);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                employees.add(mapResultSetToEmployee(rs));
            }
        } catch (SQLException e) {
            logger.error("Error retrieving employees by salary range {} - {}", minSalary, maxSalary, e);
        }
        return employees;
    }

    // 4. Two Update operations
    @Override
    public void update(Employee employee) {
        String sql = "UPDATE employees SET first_name = ?, last_name = ?, role = ?, salary = ?, skills = ? " +
                "WHERE id = ? ";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, employee.getFirstName());
            stmt.setString(2, employee.getLastName());
            stmt.setString(3, employee.getRole());
            stmt.setDouble(4, employee.getSalary());
            stmt.setString(5, employee.getSkills());
            stmt.setLong(6, employee.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error updating employee with ID {}", employee.getId(), e);
        }
    }

    @Override
    public void updateSkills(Long id, String skills) {
        String sql = "UPDATE employees SET skills = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, skills);
            stmt.setLong(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error updating skills for employee ID {}", id, e);
        }
    }

    // 5. Two Delete operations
    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error deleting employee with ID {}", id, e);
        }
    }

    @Override
    public void deleteBySalaryRange(Double minSalary, Double maxSalary) {
        String sql = "DELETE FROM employees WHERE salary BETWEEN ? AND ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, minSalary);
            stmt.setDouble(2, maxSalary);
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error deleting employees with salary between {} and {}", minSalary, maxSalary, e);
        }
    }

    private Employee mapResultSetToEmployee(ResultSet rs) throws SQLException {
        Employee employee = new Employee();
        employee.setId(rs.getLong("id"));
        employee.setFirstName(rs.getString("first_name"));
        employee.setLastName(rs.getString("last_name"));
        employee.setRole(rs.getString("role"));
        employee.setSalary(rs.getDouble("salary"));
        employee.setSkills(rs.getString("skills"));
        return employee;
    }
}
*/
