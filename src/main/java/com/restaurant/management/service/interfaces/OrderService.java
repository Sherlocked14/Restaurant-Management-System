package com.restaurant.management.service.interfaces;

import com.restaurant.management.model.entity.Order;

import java.util.List;

public interface OrderService {
    void placeOrder(Order order);
    List<Order> getAllOrders();
    Order getOrderById(int id);
}
