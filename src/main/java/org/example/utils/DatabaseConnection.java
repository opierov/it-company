package org.example.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    public static Connection connection;

    static {
        try {
            Properties properties = new Properties();
            try (InputStream input = DatabaseConnection.class.getClassLoader().getResourceAsStream("config.properties")) {
                if (input == null) {
                    throw new RuntimeException("Unable to find config.properties");
                }
                properties.load(input);
            }

            Class.forName(properties.getProperty("db.driver"));

            connection = DriverManager.getConnection(
                    properties.getProperty("db.url"),
                    properties.getProperty("db.username"),
                    properties.getProperty("db.password")
            );
        } catch (IOException | ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Database connection failed", e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
