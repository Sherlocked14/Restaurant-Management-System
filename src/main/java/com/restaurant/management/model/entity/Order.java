package com.restaurant.management.model.entity;

import java.sql.Timestamp;

public class Order {
    private int orderId;
    private int tableId;
    private int waiterId;
    private String orderStatus;
    private String orderType;
    private double totalAmount;
    private double taxAmount;
    private double discountAmount;
    private double finalAmount;
    private String specialInstructions;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    // Default Constructor
    public Order() {}

    // Constructor for creating a new order (without ID)
    public Order(int tableId, int waiterId, String orderStatus, String orderType,
                 double totalAmount, double taxAmount, double discountAmount, double finalAmount,
                 String specialInstructions, Timestamp createdAt, Timestamp updatedAt) {
        this.tableId = tableId;
        this.waiterId = waiterId;
        this.orderStatus = orderStatus;
        this.orderType = orderType;
        this.totalAmount = totalAmount;
        this.taxAmount = taxAmount;
        this.discountAmount = discountAmount;
        this.finalAmount = finalAmount;
        this.specialInstructions = specialInstructions;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Constructor for reading existing order from DB (with ID)
    public Order(int orderId, int tableId, int waiterId, String orderStatus, String orderType,
                 double totalAmount, double taxAmount, double discountAmount, double finalAmount,
                 String specialInstructions, Timestamp createdAt, Timestamp updatedAt) {
        this.orderId = orderId;
        this.tableId = tableId;
        this.waiterId = waiterId;
        this.orderStatus = orderStatus;
        this.orderType = orderType;
        this.totalAmount = totalAmount;
        this.taxAmount = taxAmount;
        this.discountAmount = discountAmount;
        this.finalAmount = finalAmount;
        this.specialInstructions = specialInstructions;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters and Setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public int getWaiterId() {
        return waiterId;
    }

    public void setWaiterId(int waiterId) {
        this.waiterId = waiterId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(double finalAmount) {
        this.finalAmount = finalAmount;
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Table ID: " + tableId + ", Waiter ID: " + waiterId +
                ", Status: " + orderStatus + ", Type: " + orderType + ", Final Amount: ₹" + finalAmount;
    }
}
