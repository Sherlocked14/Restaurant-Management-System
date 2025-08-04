package com.restaurant.management.repository;

import com.restaurant.management.config.DatabaseConnectionManager;
import com.restaurant.management.model.entity.Table;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TableDAOImpl implements TableDAO {

    private final Connection connection;

    public TableDAOImpl() throws SQLException {
        this.connection = DatabaseConnectionManager.getConnection();
    }

    @Override
    public void addTable(Table table) {
        String sql = "INSERT INTO restaurant_tables (table_number, capacity, status, location) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, table.getTableNumber());
            stmt.setInt(2, table.getCapacity());
            stmt.setString(3, table.getStatus());
            stmt.setString(4, table.getLocation());
            stmt.executeUpdate();
            System.out.println("✅ Table added successfully.");
        } catch (SQLException e) {
            System.err.println("❌ Failed to add table: " + e.getMessage());
        }
    }

    @Override
    public List<Table> getAllTables() {
        List<Table> tables = new ArrayList<>();
        String sql = "SELECT * FROM restaurant_tables";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                tables.add(new Table(
                        rs.getInt("table_id"),
                        rs.getString("table_number"),
                        rs.getInt("capacity"),
                        rs.getString("status"),
                        rs.getString("location"),
                        rs.getTimestamp("created_at")
                ));
            }
        } catch (SQLException e) {
            System.err.println("❌ Failed to retrieve tables: " + e.getMessage());
        }
        return tables;
    }

    @Override
    public Table getTableById(int id) {
        String sql = "SELECT * FROM restaurant_tables WHERE table_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Table(
                        rs.getInt("table_id"),
                        rs.getString("table_number"),
                        rs.getInt("capacity"),
                        rs.getString("status"),
                        rs.getString("location"),
                        rs.getTimestamp("created_at")
                );
            }
        } catch (SQLException e) {
            System.err.println("❌ Failed to find table by ID: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void updateTableStatus(int id, String status) {
        String sql = "UPDATE restaurant_tables SET status = ? WHERE table_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, status);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            System.out.println("✅ Table status updated.");
        } catch (SQLException e) {
            System.err.println("❌ Failed to update table status: " + e.getMessage());
        }
    }
}
