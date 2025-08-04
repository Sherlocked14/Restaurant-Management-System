package com.restaurant.management;

import com.restaurant.management.config.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            Connection conn = DatabaseConnectionManager.getConnection();
            if (conn != null) {
                System.out.println("✅ PostgreSQL connection successful!");
            }
            DatabaseConnectionManager.closeConnection();
        } catch (SQLException e) {
            System.err.println("❌ Connection failed: " + e.getMessage());
        }
    }
}
