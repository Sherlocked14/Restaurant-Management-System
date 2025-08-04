package com.restaurant.management.model.entity;

import java.math.BigDecimal;

public class MenuItem {

    private int itemId;
    private String itemName;
    private String description;
    private BigDecimal price;
    private int categoryId;
    private boolean isAvailable;
    private int preparationTime; // in minutes

    // Constructor for insert (no ID)
    public MenuItem(String itemName, String description, BigDecimal price, int categoryId, boolean isAvailable, int preparationTime) {
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.categoryId = categoryId;
        this.isAvailable = isAvailable;
        this.preparationTime = preparationTime;
    }

    // Constructor for fetch (with ID)
    public MenuItem(int itemId, String itemName, String description, BigDecimal price, int categoryId, boolean isAvailable, int preparationTime) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.categoryId = categoryId;
        this.isAvailable = isAvailable;
        this.preparationTime = preparationTime;
    }

    // Getters and setters

    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }
}
