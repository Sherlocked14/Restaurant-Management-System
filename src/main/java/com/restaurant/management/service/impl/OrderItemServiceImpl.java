package com.restaurant.management.service.impl;

import com.restaurant.management.model.entity.OrderItem;
import com.restaurant.management.repository.OrderItemDAO;
import com.restaurant.management.repository.OrderItemDAOImpl;
import com.restaurant.management.service.interfaces.OrderItemService;

import java.sql.SQLException;
import java.util.List;

public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemDAO orderItemDAO;

    public OrderItemServiceImpl() throws SQLException {
        this.orderItemDAO = new OrderItemDAOImpl();
    }

    @Override
    public void addOrderItem(OrderItem item) {
        orderItemDAO.addOrderItem(item);
    }

    @Override
    public List<OrderItem> getItemsForOrder(int orderId) {
        return orderItemDAO.getOrderItemsByOrderId(orderId);
    }
}
