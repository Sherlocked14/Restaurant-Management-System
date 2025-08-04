package com.restaurant.management.service.interfaces;

import com.restaurant.management.model.entity.OrderItem;

import java.util.List;

public interface KitchenService {
    List<OrderItem> getPendingItems();
    void updateItemStatus(int orderItemId, String newStatus);
}
