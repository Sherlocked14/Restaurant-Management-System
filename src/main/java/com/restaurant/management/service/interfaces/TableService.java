package com.restaurant.management.service.interfaces;

import com.restaurant.management.model.entity.Table;

import java.util.List;

public interface TableService {
    void addTable(Table table);
    List<Table> getAllTables();
    Table getTableById(int id);
    void updateTableStatus(int id, String status);
}
