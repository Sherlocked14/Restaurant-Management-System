package com.restaurant.management.service.impl;

import com.restaurant.management.model.entity.User;
import com.restaurant.management.repository.UserDAO;
import com.restaurant.management.repository.UserDAOImpl;
import com.restaurant.management.service.interfaces.UserService;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    public UserServiceImpl() throws SQLException {
        this.userDAO = new UserDAOImpl();
    }

    @Override
    public void registerUser(User user) throws SQLException {
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        userDAO.createUser(user);
    }

    @Override
    public User getUserById(int userId) throws SQLException {
        return userDAO.getUserById(userId);
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        return userDAO.getAllUsers();
    }

    @Override
    public void updateUser(User user) throws SQLException {
        user.setUpdatedAt(LocalDateTime.now());
        userDAO.updateUser(user);
    }

    @Override
    public void deleteUser(int userId) throws SQLException {
        userDAO.deleteUser(userId);
    }
}
