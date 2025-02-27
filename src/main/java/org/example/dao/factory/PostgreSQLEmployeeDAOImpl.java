package org.example.dao.factory;

import org.example.dao.EmployeeDAO;
import org.example.models.Employee;

import java.util.List;
import java.util.Optional;

public class PostgreSQLEmployeeDAOImpl implements EmployeeDAO {
    @Override
    public List<Employee> getByDepartmentId(Long departmentId) {
        return List.of();
    }

    @Override
    public List<Employee> getByRole(String role) {
        return List.of();
    }

    @Override
    public List<Employee> getBySalaryRange(Double minSalary, Double maxSalary) {
        return List.of();
    }

    @Override
    public List<Employee> getBySkill(String skill) {
        return List.of();
    }

    @Override
    public void updateSkills(Long id, String skills) {

    }

    @Override
    public void deleteBySalaryRange(Double minSalary, Double maxSalary) {

    }

    @Override
    public void insert(Employee entity) {

    }

    @Override
    public Optional<Employee> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Employee> getAll() {
        return List.of();
    }

    @Override
    public void update(Employee entity) {

    }

    @Override
    public void delete(Long id) {

    }
}
