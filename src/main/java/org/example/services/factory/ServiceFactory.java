package org.example.services.factory;

import org.example.services.*;

// Abstract Factory Interface
public interface ServiceFactory {
    EmployeeService createEmployeeService();
    ProjectService createProjectService();
    ClientService createClientService();
    ConsultantService createConsultantService();
    ManagerService createManagerService();
}