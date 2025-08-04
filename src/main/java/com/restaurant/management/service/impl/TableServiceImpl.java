package com.restaurant.management.service.impl;

import com.restaurant.management.model.entity.Table;
import com.restaurant.management.repository.TableDAO;
import com.restaurant.management.repository.TableDAOImpl;
import com.restaurant.management.service.interfaces.TableService;

import java.sql.SQLException;
import java.util.List;

public class TableServiceImpl implements TableService {

    private final TableDAO tableDAO;

    public TableServiceImpl() throws SQLException {
        this.tableDAO = new TableDAOImpl();
    }

    @Override
    public void addTable(Table table) {
        tableDAO.addTable(table);
    }

    @Override
    public List<Table> getAllTables() {
        return tableDAO.getAllTables();
    }

    @Override
    public Table getTableById(int id) {
        return tableDAO.getTableById(id);
    }

    @Override
    public void updateTableStatus(int id, String status) {
        tableDAO.updateTableStatus(id, status);
    }
}
