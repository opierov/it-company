package org.example;

import org.example.dao.impl.EmployeeDAOImpl;
import org.example.services.ServiceLayer;

public class Main {
    public static void main(String[] args) {

        EmployeeDAOImpl employeeDao = new EmployeeDAOImpl();

        ServiceLayer service = new ServiceLayer(employeeDao);
        service.executeOperations();
    }
}