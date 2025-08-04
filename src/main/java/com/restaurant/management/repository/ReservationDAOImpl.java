package com.restaurant.management.repository;

import com.restaurant.management.config.DatabaseConnectionManager;
import com.restaurant.management.model.entity.Reservation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {

    private final Connection connection;

    public ReservationDAOImpl() throws SQLException {
        this.connection = DatabaseConnectionManager.getConnection();
    }

    @Override
    public void bookReservation(Reservation reservation) {
        String sql = "INSERT INTO reservations (table_id, user_id, reservation_time, status, created_at) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, reservation.getTableId());
            stmt.setInt(2, reservation.getUserId());
            stmt.setTimestamp(3, reservation.getReservationTime());
            stmt.setString(4, reservation.getStatus());
            stmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            stmt.executeUpdate();
            System.out.println("✅ Reservation created successfully.");
        } catch (SQLException e) {
            System.err.println("❌ Failed to create reservation: " + e.getMessage());
        }
    }

    @Override
    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM reservations";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                reservations.add(new Reservation(
                        rs.getInt("reservation_id"),
                        rs.getInt("table_id"),
                        rs.getInt("user_id"),
                        rs.getTimestamp("reservation_time"),
                        rs.getString("status"),
                        rs.getTimestamp("created_at")
                ));
            }
        } catch (SQLException e) {
            System.err.println("❌ Failed to retrieve reservations: " + e.getMessage());
        }
        return reservations;
    }

    @Override
    public List<Reservation> getReservationsByTableId(int tableId) {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM reservations WHERE table_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, tableId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                reservations.add(new Reservation(
                        rs.getInt("reservation_id"),
                        rs.getInt("table_id"),
                        rs.getInt("user_id"),
                        rs.getTimestamp("reservation_time"),
                        rs.getString("status"),
                        rs.getTimestamp("created_at")
                ));
            }
        } catch (SQLException e) {
            System.err.println("❌ Failed to fetch reservations for table: " + e.getMessage());
        }
        return reservations;
    }
    
    @Override
    public Reservation getReservationById(int id) {
        String sql = "SELECT * FROM reservations WHERE reservation_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Reservation(
                        rs.getInt("reservation_id"),
                        rs.getInt("table_id"),
                        rs.getInt("user_id"),
                        rs.getTimestamp("reservation_time"),
                        rs.getString("status"),
                        rs.getTimestamp("created_at")
                );
            }
        } catch (SQLException e) {
            System.err.println("❌ Failed to fetch reservation by ID: " + e.getMessage());
        }
        return null;
    }

}
