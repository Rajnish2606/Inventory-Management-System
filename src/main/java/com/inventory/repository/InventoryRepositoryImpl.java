package com.inventory.repository;

import com.inventory.model.InventoryItem;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InventoryRepositoryImpl implements InventoryRepository {

    // Simulating an in-memory database with a map
    private final Map<String, InventoryItem> inventoryMap;

    public InventoryRepositoryImpl() {
        this.inventoryMap = new HashMap<>();
    }

    @Override
    public InventoryItem findByProductId(String productId) {
        return inventoryMap.get(productId);
    }

    @Override
    public void save(InventoryItem inventoryItem) {
        inventoryMap.put(inventoryItem.getProductId(), inventoryItem);
    }

    @Override
    public void update(InventoryItem inventoryItem) {
        inventoryMap.put(inventoryItem.getProductId(), inventoryItem);
    }
}
