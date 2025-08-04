package com.restaurant.management;

import com.restaurant.management.model.entity.Order;
import com.restaurant.management.model.entity.OrderItem;
import com.restaurant.management.service.impl.KitchenServiceImpl;
import com.restaurant.management.service.impl.OrderItemServiceImpl;
import com.restaurant.management.service.impl.OrderServiceImpl;
import com.restaurant.management.service.interfaces.KitchenService;
import com.restaurant.management.service.interfaces.OrderItemService;
import com.restaurant.management.service.interfaces.OrderService;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            OrderService orderService = new OrderServiceImpl();
            OrderItemService orderItemService = new OrderItemServiceImpl();

            // 🍽️ Step 1: Place a new Order
            Order newOrder = new Order();
            newOrder.setTableId(1);
            newOrder.setWaiterId(1);
            newOrder.setOrderStatus("PENDING");
            newOrder.setOrderType("DINE_IN");
            newOrder.setTotalAmount(39.97);  // sample sum
            newOrder.setTaxAmount(2.00);
            newOrder.setDiscountAmount(0.00);
            newOrder.setFinalAmount(41.97);
            newOrder.setSpecialInstructions("Less spicy");

            orderService.placeOrder(newOrder);
            System.out.println("✅ Order placed successfully.");

            // Step 2: Get Latest Order ID (assuming last inserted one)
            List<Order> allOrders = orderService.getAllOrders();
            Order latestOrder = allOrders.get(allOrders.size() - 1);
            int orderId = latestOrder.getOrderId();

            // 🍴 Step 3: Add Order Items
            OrderItem item1 = new OrderItem(orderId, 7, 2, 8.99, 17.98, "Extra crispy", "ORDERED", new Timestamp(System.currentTimeMillis()));
            OrderItem item2 = new OrderItem(orderId, 11, 1, 4.99, 4.99, "", "ORDERED", new Timestamp(System.currentTimeMillis()));

            orderItemService.addOrderItem(item1);
            orderItemService.addOrderItem(item2);
            System.out.println("✅ Order items added.");

            // 📋 Step 4: Display All Orders
            System.out.println("📋 All Orders:");
            for (Order order : orderService.getAllOrders()) {
                System.out.println("Order ID: " + order.getOrderId() + ", Table: " + order.getTableId() + ", Total: ₹" + order.getFinalAmount());
            }

            // 📋 Step 5: Display Items for Latest Order
            System.out.println("📦 Items in Order ID " + orderId + ":");
            List<OrderItem> items = orderItemService.getItemsForOrder(orderId);
            for (OrderItem item : items) {
                System.out.println("Item ID: " + item.getItemId() + ", Qty: " + item.getQuantity() + ", Total: ₹" + item.getTotalPrice());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            KitchenService kitchenService = new KitchenServiceImpl();
            List<OrderItem> pendingItems = kitchenService.getPendingItems();
            for (OrderItem item : pendingItems) {
                System.out.println("Item ID: " + item.getOrderItemId() + ", Status: " + item.getStatus());
            }
        
            if (!pendingItems.isEmpty()) {
                kitchenService.updateItemStatus(pendingItems.get(0).getOrderItemId(), "READY");
            }
        } catch (SQLException e) {
            System.err.println("❌ KitchenService error: " + e.getMessage());
        }        

    }
}
