package org.example.dao.factory;

import org.example.dao.*;
import org.example.dao.impl.*;

// Concrete Factory for MySQL
public class MySQLDAOFactory implements DAOFactory {
    @Override
    public EmployeeDAO createEmployeeDAO() {
        return new EmployeeDAOImpl();
    }
    @Override
    public ProjectDAO createProjectDAO() {
        return new ProjectDAOImpl();
    }
    @Override
    public ClientDAO createClientDAO() {
        return new ClientDAOImpl();
    }
    @Override
    public ConsultantDAO createConsultantDAO() {
        return new ConsultantDAOImpl();
    }
    @Override
    public ManagerDAO createManagerDAO() {
        return new ManagerDAOImpl();
    }
}
