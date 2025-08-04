package com.restaurant.management.repository;

import com.restaurant.management.config.DatabaseConnectionManager;
import com.restaurant.management.model.entity.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {

    private final Connection connection;

    public OrderDAOImpl() throws SQLException {
        this.connection = DatabaseConnectionManager.getConnection();
    }

    @Override
    public void createOrder(Order order) {
        String sql = "INSERT INTO orders (table_id, waiter_id, order_status, order_type, total_amount, tax_amount, " +
                "discount_amount, final_amount, special_instructions, created_at, updated_at) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, order.getTableId());
            stmt.setInt(2, order.getWaiterId());
            stmt.setString(3, order.getOrderStatus());
            stmt.setString(4, order.getOrderType());
            stmt.setDouble(5, order.getTotalAmount());
            stmt.setDouble(6, order.getTaxAmount());
            stmt.setDouble(7, order.getDiscountAmount());
            stmt.setDouble(8, order.getFinalAmount());
            stmt.setString(9, order.getSpecialInstructions());
            stmt.setTimestamp(10, order.getCreatedAt());
            stmt.setTimestamp(11, order.getUpdatedAt());
            stmt.executeUpdate();
            System.out.println("✅ Order created successfully.");
        } catch (SQLException e) {
            System.err.println("❌ Failed to create order: " + e.getMessage());
        }
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                orders.add(new Order(
                        rs.getInt("order_id"),
                        rs.getInt("table_id"),
                        rs.getInt("waiter_id"),
                        rs.getString("order_status"),
                        rs.getString("order_type"),
                        rs.getDouble("total_amount"),
                        rs.getDouble("tax_amount"),
                        rs.getDouble("discount_amount"),
                        rs.getDouble("final_amount"),
                        rs.getString("special_instructions"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("updated_at")
                ));
            }
        } catch (SQLException e) {
            System.err.println("❌ Failed to retrieve orders: " + e.getMessage());
        }
        return orders;
    }

    @Override
    public Order getOrderById(int id) {
        String sql = "SELECT * FROM orders WHERE order_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Order(
                        rs.getInt("order_id"),
                        rs.getInt("table_id"),
                        rs.getInt("waiter_id"),
                        rs.getString("order_status"),
                        rs.getString("order_type"),
                        rs.getDouble("total_amount"),
                        rs.getDouble("tax_amount"),
                        rs.getDouble("discount_amount"),
                        rs.getDouble("final_amount"),
                        rs.getString("special_instructions"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("updated_at")
                );
            }
        } catch (SQLException e) {
            System.err.println("❌ Failed to get order by ID: " + e.getMessage());
        }
        return null;
    }
}
