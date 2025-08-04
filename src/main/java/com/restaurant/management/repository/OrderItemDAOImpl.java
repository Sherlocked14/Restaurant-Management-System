package com.restaurant.management.repository;

import com.restaurant.management.config.DatabaseConnectionManager;
import com.restaurant.management.model.entity.OrderItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderItemDAOImpl implements OrderItemDAO {

    private final Connection connection;

    public OrderItemDAOImpl() throws SQLException {
        this.connection = DatabaseConnectionManager.getConnection();
    }

    @Override
    public void addOrderItem(OrderItem item) {
        String sql = "INSERT INTO order_items (order_id, item_id, quantity, unit_price, total_price, " +
                "special_requests, status, created_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, item.getOrderId());
            stmt.setInt(2, item.getItemId());
            stmt.setInt(3, item.getQuantity());
            stmt.setDouble(4, item.getUnitPrice());
            stmt.setDouble(5, item.getTotalPrice());
            stmt.setString(6, item.getSpecialRequests());
            stmt.setString(7, item.getStatus());
            stmt.setTimestamp(8, item.getCreatedAt());
            stmt.executeUpdate();
            System.out.println("✅ Order item added successfully.");
        } catch (SQLException e) {
            System.err.println("❌ Failed to add order item: " + e.getMessage());
        }
    }

    @Override
    public List<OrderItem> getOrderItemsByOrderId(int orderId) {
        List<OrderItem> items = new ArrayList<>();
        String sql = "SELECT * FROM order_items WHERE order_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, orderId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                items.add(new OrderItem(
                        rs.getInt("order_item_id"),
                        rs.getInt("order_id"),
                        rs.getInt("item_id"),
                        rs.getInt("quantity"),
                        rs.getDouble("unit_price"),
                        rs.getDouble("total_price"),
                        rs.getString("special_requests"),
                        rs.getString("status"),
                        rs.getTimestamp("created_at")
                ));
            }
        } catch (SQLException e) {
            System.err.println("❌ Failed to retrieve order items: " + e.getMessage());
        }
        return items;
    }
    @Override
    public List<OrderItem> getItemsByStatus(String... statuses) {
        List<OrderItem> items = new ArrayList<>();
        StringBuilder placeholders = new StringBuilder();
        for (int i = 0; i < statuses.length; i++) {
            placeholders.append("?");
            if (i < statuses.length - 1) placeholders.append(",");
        }

        String sql = "SELECT * FROM order_items WHERE status IN (" + placeholders + ")";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            for (int i = 0; i < statuses.length; i++) {
                stmt.setString(i + 1, statuses[i]);
            }

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                items.add(new OrderItem(
                        rs.getInt("order_item_id"),
                        rs.getInt("order_id"),
                        rs.getInt("item_id"),
                        rs.getInt("quantity"),
                        rs.getDouble("unit_price"),
                        rs.getDouble("total_price"),
                        rs.getString("special_requests"),
                        rs.getString("status"),
                        rs.getTimestamp("created_at")
                ));
            }
        } catch (SQLException e) {
            System.err.println("❌ Failed to fetch pending items: " + e.getMessage());
        }
        return items;
    }

    @Override
    public void updateItemStatus(int orderItemId, String status) {
        String sql = "UPDATE order_items SET status = ? WHERE order_item_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, status);
            stmt.setInt(2, orderItemId);
            stmt.executeUpdate();
            System.out.println("✅ Item status updated to " + status);
        } catch (SQLException e) {
            System.err.println("❌ Failed to update item status: " + e.getMessage());
        }
    }

}
