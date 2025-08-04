package com.restaurant.management.model.entity;

import java.sql.Timestamp;

public class Reservation {
    private int reservationId;
    private int tableId;
    private int userId;
    private Timestamp reservationTime;
    private String status;
    private Timestamp createdAt;

    // ✅ Constructor for full record (used when reading from DB)
    public Reservation(int reservationId, int tableId, int userId, Timestamp reservationTime, String status, Timestamp createdAt) {
        this.reservationId = reservationId;
        this.tableId = tableId;
        this.userId = userId;
        this.reservationTime = reservationTime;
        this.status = status;
        this.createdAt = createdAt;
    }

    // ✅ Constructor for inserting a new reservation (used in creation logic)
    public Reservation(int tableId, int userId, Timestamp reservationTime, String status) {
        this.tableId = tableId;
        this.userId = userId;
        this.reservationTime = reservationTime;
        this.status = status;
    }

    // 👇 Getters & Setters

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(Timestamp reservationTime) {
        this.reservationTime = reservationTime;
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
}
