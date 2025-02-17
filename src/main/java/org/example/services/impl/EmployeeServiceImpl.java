package org.example.services.impl;

import org.example.dao.EmployeeDAO;
import org.example.dao.impl.EmployeeDAOImpl;
import org.example.models.Employee;
import org.example.services.EmployeeService;

import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO;

    public EmployeeServiceImpl() {
        this.employeeDAO = new EmployeeDAOImpl();
    }

    @Override
    public void add(Employee employee) {
        employeeDAO.insert(employee);
    }

    @Override
    public Optional<Employee> getById(Long id) {
        return employeeDAO.getById(id);
    }

    @Override
    public List<Employee> getAll() {
        return employeeDAO.getAll();
    }

    @Override
    public void update(Employee employee) {
        employeeDAO.update(employee);
    }

    @Override
    public void delete(Long id) {
        employeeDAO.delete(id);
    }

    @Override
    public List<Employee> getEmployeesByRole(String role) {
        return employeeDAO.getByRole(role);
    }

    @Override
    public List<Employee> getEmployeesByDepartment(Long departmentId) {
        return employeeDAO.getByDepartmentId(departmentId);
    }

    @Override
    public List<Employee> getBySalaryRange(Double minSalary, Double maxSalary) {
        return employeeDAO.getBySalaryRange(minSalary, maxSalary);
    }

    @Override
    public List<Employee> getBySkill(String skill) {
        return employeeDAO.getBySkill(skill);
    }

    @Override
    public void updateEmployeeSkills(Long id, String skills) {
        employeeDAO.updateSkills(id, skills);
    }

    @Override
    public void deleteEmployeesBySalaryRange(Double minSalary, Double maxSalary) {
        employeeDAO.deleteBySalaryRange(minSalary, maxSalary);
    }
}