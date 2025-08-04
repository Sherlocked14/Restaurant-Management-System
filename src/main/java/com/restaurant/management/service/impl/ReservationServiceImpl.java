package com.restaurant.management.service.impl;

import com.restaurant.management.model.entity.Reservation;
import com.restaurant.management.repository.ReservationDAO;
import com.restaurant.management.repository.ReservationDAOImpl;
import com.restaurant.management.service.interfaces.ReservationService;

import java.sql.SQLException;
import java.util.List;

public class ReservationServiceImpl implements ReservationService {

    private final ReservationDAO reservationDAO;

    public ReservationServiceImpl() throws SQLException {
        this.reservationDAO = new ReservationDAOImpl();
    }

    @Override
    public void bookReservation(Reservation reservation) {
        reservationDAO.bookReservation(reservation);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationDAO.getAllReservations();
    }

    @Override
    public Reservation getReservationById(int id) {
        return reservationDAO.getReservationById(id);
    }
}
