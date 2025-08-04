package com.restaurant.management.repository;

import com.restaurant.management.model.entity.Reservation;
import java.util.List;

public interface ReservationDAO {
    void bookReservation(Reservation reservation);
    List<Reservation> getAllReservations();
    List<Reservation> getReservationsByTableId(int tableId);
    Reservation getReservationById(int id); // ✅ NEW METHOD
}
