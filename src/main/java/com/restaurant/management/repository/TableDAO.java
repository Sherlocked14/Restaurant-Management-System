package com.restaurant.management.repository;

import com.restaurant.management.model.entity.Table;
import java.util.List;

public interface TableDAO {
    void addTable(Table table);
    List<Table> getAllTables();
    Table getTableById(int id);
    void updateTableStatus(int id, String status);
}
