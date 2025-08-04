package com.restaurant.management.repository;

import com.restaurant.management.model.entity.OrderItem;

import java.util.List;

public interface OrderItemDAO {
    void addOrderItem(OrderItem item);
    List<OrderItem> getOrderItemsByOrderId(int orderId);
    List<OrderItem> getItemsByStatus(String... statuses);
    void updateItemStatus(int orderItemId, String status);

}
