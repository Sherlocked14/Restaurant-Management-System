package com.restaurant.management.model.entity;

import java.sql.Timestamp;

public class OrderItem {
    private int orderItemId;
    private int orderId;
    private int itemId;
    private int quantity;
    private double unitPrice;
    private double totalPrice;
    private String specialRequests;
    private String status;
    private Timestamp createdAt;

    // Default Constructor
    public OrderItem() {}

    // Constructor for creating a new order item (without ID)
    public OrderItem(int orderId, int itemId, int quantity, double unitPrice,
                     double totalPrice, String specialRequests, String status, Timestamp createdAt) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.specialRequests = specialRequests;
        this.status = status;
        this.createdAt = createdAt;
    }

    // Constructor for reading existing order item from DB (with ID)
    public OrderItem(int orderItemId, int orderId, int itemId, int quantity, double unitPrice,
                     double totalPrice, String specialRequests, String status, Timestamp createdAt) {
        this.orderItemId = orderItemId;
        this.orderId = orderId;
        this.itemId = itemId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.specialRequests = specialRequests;
        this.status = status;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getSpecialRequests() {
        return specialRequests;
    }

    public void setSpecialRequests(String specialRequests) {
        this.specialRequests = specialRequests;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "OrderItem ID: " + orderItemId + ", Order ID: " + orderId + ", Item ID: " + itemId +
                ", Quantity: " + quantity + ", Total Price: ₹" + totalPrice + ", Status: " + status;
    }
}
