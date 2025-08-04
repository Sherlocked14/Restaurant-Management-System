package com.restaurant.management.model.entity;

import java.sql.Timestamp;

public class Bill {
    private int billId;
    private int orderId;
    private double subtotal;
    private double tax;
    private double discount;
    private double totalAmount;
    private Timestamp generatedAt;

    public Bill() {}

    public Bill(int billId, int orderId, double subtotal, double tax, double discount, double totalAmount, Timestamp generatedAt) {
        this.billId = billId;
        this.orderId = orderId;
        this.subtotal = subtotal;
        this.tax = tax;
        this.discount = discount;
        this.totalAmount = totalAmount;
        this.generatedAt = generatedAt;
    }

    public int getBillId() { return billId; }
    public void setBillId(int billId) { this.billId = billId; }

    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public double getSubtotal() { return subtotal; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }

    public double getTax() { return tax; }
    public void setTax(double tax) { this.tax = tax; }

    public double getDiscount() { return discount; }
    public void setDiscount(double discount) { this.discount = discount; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public Timestamp getGeneratedAt() { return generatedAt; }
    public void setGeneratedAt(Timestamp generatedAt) { this.generatedAt = generatedAt; }
}
