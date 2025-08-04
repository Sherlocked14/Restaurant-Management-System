package com.restaurant.management.service.interfaces;

import com.restaurant.management.model.entity.Reservation;

import java.util.List;

public interface ReservationService {
    void bookReservation(Reservation reservation);
    List<Reservation> getAllReservations();
    Reservation getReservationById(int id);
}
