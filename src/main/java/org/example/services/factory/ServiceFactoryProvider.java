package org.example.services.factory;

// Factory Selector
public class ServiceFactoryProvider {
    public static ServiceFactory getFactory(String type) {
        if ("MYSQL".equalsIgnoreCase(type)) {
            return new MySQLServiceFactory();
        }
        throw new IllegalArgumentException("Unknown database type");
    }
}