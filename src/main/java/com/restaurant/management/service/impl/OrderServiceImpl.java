package com.restaurant.management.service.impl;

import com.restaurant.management.model.entity.Order;
import com.restaurant.management.repository.OrderDAO;
import com.restaurant.management.repository.OrderDAOImpl;
import com.restaurant.management.service.interfaces.OrderService;

import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    private final OrderDAO orderDAO;

    public OrderServiceImpl() throws SQLException {
        this.orderDAO = new OrderDAOImpl();
    }

    @Override
    public void placeOrder(Order order) {
        orderDAO.createOrder(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }

    @Override
    public Order getOrderById(int id) {
        return orderDAO.getOrderById(id);
    }
}
