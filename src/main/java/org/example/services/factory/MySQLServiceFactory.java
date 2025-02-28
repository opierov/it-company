package org.example.services.factory;

import org.example.services.*;
import org.example.services.impl.*;

// Concrete Factory for MySQL
public class MySQLServiceFactory implements ServiceFactory {
    @Override
    public EmployeeService createEmployeeService() {
        return new EmployeeServiceImpl();
    }
    @Override
    public ProjectService createProjectService() {
        return new ProjectServiceImpl();
    }
    @Override
    public ClientService createClientService() {
        return new ClientServiceImpl();
    }
    @Override
    public ConsultantService createConsultantService() {
        return new ConsultantServiceImpl();
    }
    @Override
    public ManagerService createManagerService() {
        return new ManagerServiceImpl();
    }
}
