package org.example.service;

import org.example.model.Employee;
import org.example.dao.EmployeeDAO;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public Employee getById(Long id) {
        return employeeDAO.findById((long) id);
    }

    @Override
    public void add(Employee entity) {

    }

    @Override
    public Employee getById(int id) {
        return null;
    }

    @Override
    public List<Employee> getAll() {
        return employeeDAO.findAll();
    }

    @Override
    public void update(Employee employee) {
        employeeDAO.update(employee);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void delete(Long id) {
        employeeDAO.delete(id);
    }

    @Override
    public List<Employee> getEmployeesByDepartment(Long departmentId) {
        return employeeDAO.findByDepartment(departmentId);
    }
}
