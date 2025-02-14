package org.example.service;

import org.example.model.Employee;

import java.util.List;

public interface EmployeeService extends Service<Employee> {
    Employee getById(Long id);

    void delete(Long id);

    List<Employee> getEmployeesByDepartment(Long departmentId);
}
