package org.example.services.factory;

import org.example.services.Service;
import org.example.services.impl.*;

public class ServiceFactory {
    public static Service getService(ServiceType type) {
        switch (type) {
            case EMPLOYEE:
                return new EmployeeServiceImpl();
            case CLIENT:
                return new ClientServiceImpl();
            case PROJECT:
                return new ProjectServiceImpl();
            case CONSULTANT:
                return new ConsultantServiceImpl();
            case MANAGER:
                return new ManagerServiceImpl();
            default:
                throw new IllegalArgumentException("Invalid Service type");
        }
    }

    public enum ServiceType {
        EMPLOYEE, CLIENT, PROJECT, CONSULTANT, MANAGER
    }
}