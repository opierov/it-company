package org.example.services;

import org.example.dao.impl.EmployeeDAOImpl;
import org.example.models.Employee;

import java.util.List;

public class ServiceLayer {

    private final EmployeeDAOImpl employeeDao;


    public ServiceLayer(EmployeeDAOImpl employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void executeOperations() {

        employeeDao.insertEmployee(new Employee());

        List<Employee> employeesByProject = employeeDao.getEmployeesByProject("Test project");

        List<Employee> allEmployees = employeeDao.getAllEmployees();

        employeeDao.updateEmployeeSalary(1L, 75000.0);

        employeeDao.deleteEmployee(3L);
    }
}

