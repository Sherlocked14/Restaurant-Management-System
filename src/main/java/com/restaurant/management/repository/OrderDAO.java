package com.restaurant.management.repository;

import com.restaurant.management.model.entity.Order;

import java.util.List;

public interface OrderDAO {
    void createOrder(Order order);
    List<Order> getAllOrders();
    Order getOrderById(int id);
}
