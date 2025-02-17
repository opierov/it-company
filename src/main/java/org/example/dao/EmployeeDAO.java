package org.example.dao;

import org.example.models.Employee;
import java.util.List;

public interface EmployeeDAO extends BaseDAO<Employee> {

    List<Employee> getByDepartmentId(Long departmentId);

    List<Employee> getByRole(String role);
    List<Employee> getBySalaryRange(Double minSalary, Double maxSalary);
    List<Employee> getBySkill(String skill);

    void updateSkills(Long id, String skills);

    void deleteBySalaryRange(Double minSalary, Double maxSalary);
}