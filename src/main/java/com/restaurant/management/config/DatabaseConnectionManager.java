package com.restaurant.management.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionManager {

    private static final String PROPERTIES_FILE = "src/main/resources/db.properties";
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Properties props = new Properties();
                FileInputStream fis = new FileInputStream(PROPERTIES_FILE);
                props.load(fis);

                String url = props.getProperty("db.url");
                String user = props.getProperty("db.username");
                String password = props.getProperty("db.password");

                connection = DriverManager.getConnection(url, user, password);

            } catch (IOException e) {
                System.err.println("Error reading database configuration: " + e.getMessage());
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}
