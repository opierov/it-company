package org.example.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.example.model.Employee;

import static org.example.DatabaseConnection.connection;

public class EmployeeDAOImpl implements EmployeeDAO {

    public EmployeeDAOImpl() {
    }

    @Override
    public void insert(Employee employee) {
        String sql = "INSERT INTO employees (first_name, last_name, role, salary, skills) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, employee.getFirstName());
            stmt.setString(2, employee.getLastName());
            stmt.setString(3, employee.getRole());
            stmt.setDouble(4, employee.getSalary());
            stmt.setString(5, employee.getSkills());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Employee> getById(Long id) {
        String sql = "SELECT * FROM employees WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getLong("id"));
                employee.setFirstName(rs.getString("first_name"));
                employee.setLastName(rs.getString("last_name"));
                employee.setRole(rs.getString("role"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setSkills(rs.getString("skills"));
                return Optional.of(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getLong("id"));
                employee.setFirstName(rs.getString("first_name"));
                employee.setLastName(rs.getString("last_name"));
                employee.setRole(rs.getString("role"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setSkills(rs.getString("skills"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public void update(Employee employee) {
        String sql = "UPDATE employees SET first_name = ?, last_name = ?, role = ?, salary = ?, skills = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, employee.getFirstName());
            stmt.setString(2, employee.getLastName());
            stmt.setString(3, employee.getRole());
            stmt.setDouble(4, employee.getSalary());
            stmt.setString(5, employee.getSkills());
            stmt.setLong(6, employee.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> getByDepartmentId(Long departmentId) {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT e.* FROM employees e JOIN teams t ON e.id = t.employees_id JOIN departments d ON t.id = d.teams_id WHERE d.id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, departmentId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getLong("id"));
                employee.setFirstName(rs.getString("first_name"));
                employee.setLastName(rs.getString("last_name"));
                employee.setRole(rs.getString("role"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setSkills(rs.getString("skills"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public Employee findById(Long id) {
        return null;
    }

    @Override
    public List<Employee> findByDepartment(Long departmentId) {
        return List.of();
    }

    @Override
    public List<Employee> findAll() {
        return List.of();
    }

    public void insertEmployee(Employee employee) {
    }

    public List<Employee> getEmployeesByProject(String development) {
        return List.of();
    }

    public List<Employee> getAllEmployees() {
        return List.of();
    }

    public void updateEmployeeSalary(Long id, Double salary) {
    }

    public void deleteEmployee(Long id) {
    }
}
