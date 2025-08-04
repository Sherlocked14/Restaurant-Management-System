package com.restaurant.management.service.interfaces;

import com.restaurant.management.model.entity.OrderItem;

import java.util.List;

public interface OrderItemService {
    void addOrderItem(OrderItem item);
    List<OrderItem> getItemsForOrder(int orderId);
}
