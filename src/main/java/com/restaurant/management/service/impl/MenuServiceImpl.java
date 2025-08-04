package com.restaurant.management.service.impl;

import com.restaurant.management.model.entity.MenuItem;
import com.restaurant.management.repository.MenuItemDAO;
import com.restaurant.management.repository.MenuItemDAOImpl;
import com.restaurant.management.service.interfaces.MenuService;

import java.sql.SQLException;
import java.util.List;

public class MenuServiceImpl implements MenuService {

    private final MenuItemDAO menuItemDAO;

    public MenuServiceImpl() throws SQLException {
        this.menuItemDAO = new MenuItemDAOImpl();
    }

    @Override
    public void addMenuItem(MenuItem menuItem) {
        menuItemDAO.addMenuItem(menuItem);
    }

    @Override
    public List<MenuItem> getAllMenuItems() {
        return menuItemDAO.getAllMenuItems();
    }
}
