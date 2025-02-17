package org.example.services;

import org.example.models.Employee;
import java.util.List;

public interface EmployeeService extends Service<Employee> {

    List<Employee> getEmployeesByRole(String role);
    List<Employee> getEmployeesByDepartment(Long departmentId);
    List<Employee> getBySalaryRange(Double minSalary, Double maxSalary);
    List<Employee> getBySkill(String skill);
    void updateEmployeeSkills(Long id, String skills);
    void deleteEmployeesBySalaryRange(Double minSalary, Double maxSalary);
}