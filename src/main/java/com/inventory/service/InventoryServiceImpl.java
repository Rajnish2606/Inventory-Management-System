package com.inventory.service;

import com.inventory.model.InventoryItem;
import com.inventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;
    private final Object lock = new Object(); // Object used for synchronization

    @Autowired
    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public void deductInventory(String productId, int quantity) throws IllegalArgumentException {
        synchronized (lock) {
            // Retrieve the inventory item for the given product ID
            InventoryItem item = inventoryRepository.findByProductId(productId);

            // If the product doesn't exist in inventory, throw exception
            if (item == null) {
                throw new IllegalArgumentException("Product with ID " + productId + " not found in inventory.");
            }

            // Check if there is sufficient quantity available
            int currentQuantity = item.getQuantity();
            if (currentQuantity < quantity) {
                throw new IllegalArgumentException("Insufficient inventory for product with ID " + productId);
            }

            // Deduct the specified quantity from the inventory
            item.setQuantity(currentQuantity - quantity);
            inventoryRepository.update(item);
        }
    }

    @Override
    public void addInventory(String productId, int quantity) {
        synchronized (lock) {
            // Retrieve the inventory item for the given product ID
            InventoryItem item = inventoryRepository.findByProductId(productId);

            // If the product doesn't exist in inventory, create a new entry
            if (item == null) {
                item = new InventoryItem(productId, quantity);
                inventoryRepository.save(item);
            } else {
                // If the product exists, update its quantity
                int currentQuantity = item.getQuantity();
                item.setQuantity(currentQuantity + quantity);
                inventoryRepository.update(item);
            }
        }
    }
}
