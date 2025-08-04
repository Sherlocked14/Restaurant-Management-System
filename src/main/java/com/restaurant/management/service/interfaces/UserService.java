package com.restaurant.management.service.interfaces;

import com.restaurant.management.model.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    void registerUser(User user) throws SQLException;

    User getUserById(int userId) throws SQLException;

    List<User> getAllUsers() throws SQLException;

    void updateUser(User user) throws SQLException;

    void deleteUser(int userId) throws SQLException;
}
