package org.example.dao.factory;

import org.example.dao.*;
import org.example.dao.impl.*;

// Abstract Factory Interface
public interface DAOFactory {
    EmployeeDAO createEmployeeDAO();
    ProjectDAO createProjectDAO();
    ClientDAO createClientDAO();
    ConsultantDAO createConsultantDAO();
    ManagerDAO createManagerDAO();
}