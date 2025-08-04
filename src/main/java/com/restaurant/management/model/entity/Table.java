package com.restaurant.management.model.entity;

import java.sql.Timestamp;

public class Table {
    private int tableId;
    private String tableNumber;
    private int capacity;
    private String status;
    private String location;
    private Timestamp createdAt;

    // ✅ Constructor used when fetching from DB
    public Table(int tableId, String tableNumber, int capacity, String status, String location, Timestamp createdAt) {
        this.tableId = tableId;
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.status = status;
        this.location = location;
        this.createdAt = createdAt;
    }

    // ✅ Constructor used when inserting a new table
    public Table(String tableNumber, int capacity, String status, String location) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.status = status;
        this.location = location;
    }

    // 👇 Getters & Setters (generate if missing)

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public String getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
