package org.example.services;

import org.example.models.Employee;

import java.util.List;

public interface EmployeeService extends Service<Employee> {
    Employee getById(Long id);

    void delete(Long id);

    List<Employee> getEmployeesByDepartment(Long departmentId);
}
