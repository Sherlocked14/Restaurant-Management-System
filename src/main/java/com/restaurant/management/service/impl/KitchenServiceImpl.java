package com.restaurant.management.service.impl;

import com.restaurant.management.model.entity.OrderItem;
import com.restaurant.management.repository.OrderItemDAO;
import com.restaurant.management.repository.OrderItemDAOImpl;
import com.restaurant.management.service.interfaces.KitchenService;

import java.sql.SQLException;
import java.util.List;

public class KitchenServiceImpl implements KitchenService {

    private final OrderItemDAO orderItemDAO;

    public KitchenServiceImpl() throws SQLException {
        this.orderItemDAO = new OrderItemDAOImpl();
    }

    @Override
    public List<OrderItem> getPendingItems() {
        return orderItemDAO.getItemsByStatus("ORDERED", "PREPARING");
    }

    @Override
    public void updateItemStatus(int orderItemId, String newStatus) {
        orderItemDAO.updateItemStatus(orderItemId, newStatus);
    }
}
