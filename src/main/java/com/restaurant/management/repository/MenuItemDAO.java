package com.restaurant.management.repository;

import com.restaurant.management.model.entity.MenuItem;

import java.util.List;

public interface MenuItemDAO {
    void addMenuItem(MenuItem menuItem);
    List<MenuItem> getAllMenuItems();
}
