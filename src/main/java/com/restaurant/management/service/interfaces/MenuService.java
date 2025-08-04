package com.restaurant.management.service.interfaces;

import com.restaurant.management.model.entity.MenuItem;
import java.util.List;

public interface MenuService {
    void addMenuItem(MenuItem menuItem);
    List<MenuItem> getAllMenuItems();
}
