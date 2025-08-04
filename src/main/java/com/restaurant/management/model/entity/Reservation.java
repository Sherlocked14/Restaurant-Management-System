package com.restaurant.management.model.entity;

import java.time.LocalDateTime;

public class Reservation {
    private int reservationId;
    private int tableId;
    private int userId;
    private LocalDateTime reservationTime;
    private int partySize;
    private String status;
    private String specialRequest;

    public Reservation() {
    }

    public Reservation(int reservationId, int tableId, int userId, LocalDateTime reservationTime,
                       int partySize, String status, String specialRequest) {
        this.reservationId = reservationId;
        this.tableId = tableId;
        this.userId = userId;
        this.reservationTime = reservationTime;
        this.partySize = partySize;
        this.status = status;
        this.specialRequest = specialRequest;
    }

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

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(LocalDateTime reservationTime) {
        this.reservationTime = reservationTime;
    }

    public int getPartySize() {
        return partySize;
    }

    public void setPartySize(int partySize) {
        this.partySize = partySize;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecialRequest() {
        return specialRequest;
    }

    public void setSpecialRequest(String specialRequest) {
        this.specialRequest = specialRequest;
    }
}
