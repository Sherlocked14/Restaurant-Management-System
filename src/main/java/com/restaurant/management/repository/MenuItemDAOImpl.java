package com.restaurant.management.repository;

import com.restaurant.management.config.DatabaseConnectionManager;
import com.restaurant.management.model.entity.MenuItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class MenuItemDAOImpl implements MenuItemDAO {

    private final Connection connection;

    public MenuItemDAOImpl() throws SQLException {
        this.connection = DatabaseConnectionManager.getConnection();
    }

    @Override
    public void addMenuItem(MenuItem item) {
        String sql = "INSERT INTO menu_items (item_name, description, price, category_id, is_available, preparation_time) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, item.getItemName());
            stmt.setString(2, item.getDescription());
            stmt.setBigDecimal(3, item.getPrice());
            stmt.setInt(4, item.getCategoryId());
            stmt.setBoolean(5, item.isAvailable());
            stmt.setInt(6, item.getPreparationTime());
            stmt.executeUpdate();
            System.out.println("✅ Menu item added successfully.");
        } catch (SQLException e) {
            System.err.println("❌ Failed to add menu item: " + e.getMessage());
        }
    }

    @Override
    public List<MenuItem> getAllMenuItems() {
        List<MenuItem> items = new ArrayList<>();
        String sql = "SELECT * FROM menu_items";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                items.add(new MenuItem(
                        rs.getInt("item_id"),
                        rs.getString("item_name"),
                        rs.getString("description"),
                        rs.getBigDecimal("price"),
                        rs.getInt("category_id"),
                        rs.getBoolean("is_available"),
                        rs.getInt("preparation_time")
                ));
            }
        } catch (SQLException e) {
            System.err.println("❌ Failed to retrieve menu items: " + e.getMessage());
        }
        return items;
    }
}
