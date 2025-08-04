package com.restaurant.management.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionUtil {

    private static final String URL = "jdbc:postgresql://localhost:5432/restaurant_db"; // change if needed
    private static final String USER = "restaurant_user";
    private static final String PASSWORD = "restaurant_password";

    private DatabaseConnectionUtil() {}

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
