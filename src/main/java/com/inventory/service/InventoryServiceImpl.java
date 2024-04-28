package com.inventory.service;

import com.inventory.model.InventoryItem;
import com.inventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Concrete implementation of the InventoryService interface.
 * This class provides methods to handle inventory-related operations.
 */
@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    /**
     * Deducts the specified quantity of a product from the inventory.
     * Throws IllegalArgumentException if the product doesn't exist or if there is insufficient quantity.
     *
     * @param productId The ID of the product to deduct inventory from
     * @param quantity  The quantity to deduct
     * @throws IllegalArgumentException If the product doesn't exist or if there is insufficient quantity
     */
    @Override
    public void deductInventory(String productId, int quantity) throws IllegalArgumentException {
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

    /**
     * Adds the specified quantity of a product to the inventory.
     * If the product doesn't exist in inventory, creates a new entry.
     *
     * @param productId The ID of the product to add inventory to
     * @param quantity  The quantity to add
     */
    @Override
    public void addInventory(String productId, int quantity) {
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

