package org.example.dao.factory;

import org.example.dao.*;
import org.example.dao.impl.*;

// Factory Selector
public class DAOFactoryProvider {
    public static DAOFactory getFactory(String type) {
        if ("MYSQL".equalsIgnoreCase(type)) {
            return new MySQLDAOFactory();
        } else if ("POSTGRESQL".equalsIgnoreCase(type)) {
            return new PostgreSQLDAOFactory();
        }
        throw new IllegalArgumentException("Unknown database type");
    }
}