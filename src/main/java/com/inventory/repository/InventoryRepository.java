package com.inventory.repository;

import com.inventory.model.InventoryItem;

public interface InventoryRepository {

    InventoryItem findByProductId(String productId);

    void save(InventoryItem inventoryItem);

    void update(InventoryItem inventoryItem);

}

