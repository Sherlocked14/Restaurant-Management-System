package com.restaurant.management;

import com.restaurant.management.model.entity.User;
import com.restaurant.management.service.impl.UserServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            UserServiceImpl userService = new UserServiceImpl();

            // Create new user
            User newUser = new User();
            newUser.setUsername("john_doe");
            newUser.setPassword("password123");
            newUser.setFullName("John Doe");
            newUser.setRole("WAITER");
            newUser.setEmail("john@example.com");
            newUser.setPhone("9876543210");
            newUser.setActive(true);

            userService.registerUser(newUser);
            System.out.println("✅ User created successfully!");

            // List all users
            List<User> users = userService.getAllUsers();
            System.out.println("📋 List of users:");
            for (User user : users) {
                System.out.println(user.getUserId() + " - " + user.getUsername() + " - " + user.getRole());
            }

        } catch (SQLException e) {
            System.err.println("❌ Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
