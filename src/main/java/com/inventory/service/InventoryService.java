package com.inventory.service;

import com.inventory.model.InventoryItem;

public interface InventoryService {

    void deductInventory(String productId, int quantity) throws IllegalArgumentException;

    void addInventory(String productId, int quantity) throws IllegalArgumentException;
}

