package org.example.dao.factory;

import org.example.dao.*;
import org.example.dao.impl.*;

// Concrete Factory for PostgreSQL (if needed in future)
public class PostgreSQLDAOFactory implements DAOFactory {
    @Override
    public EmployeeDAO createEmployeeDAO() {
        return new PostgreSQLEmployeeDAOImpl();
    }
    @Override
    public ProjectDAO createProjectDAO() {
        return new PostgreSQLProjectDAOImpl();
    }
    @Override
    public ClientDAO createClientDAO() {
        return new PostgreSQLClientDAOImpl();
    }
    @Override
    public ConsultantDAO createConsultantDAO() {
        return new PostgreSQLConsultantDAOImpl();
    }
    @Override
    public ManagerDAO createManagerDAO() {
        return new PostgreSQLManagerDAOImpl();
    }
}
