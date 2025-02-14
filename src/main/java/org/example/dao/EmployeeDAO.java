package org.example.dao;

import org.example.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDAO extends BaseDAO<Employee> {
    Optional<Employee> getById(Long id);

    List<Employee> getByDepartmentId(Long departmentId);

    Employee findById(Long id);

    List<Employee> findByDepartment(Long departmentId);

    List<Employee> findAll();
}