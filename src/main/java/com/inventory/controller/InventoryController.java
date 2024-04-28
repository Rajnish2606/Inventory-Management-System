package com.inventory.controller;

import com.inventory.model.InventoryItem;
import com.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    /**
     * Endpoint to deduct inventory quantity for a given product.
     *
     * Request method: POST
     * Endpoint: /inventory/deduct
     * Request body format: {"productId": "product_id", "quantity": quantity}
     * Response format: Success message or error message
     * Transaction validation rules: Quantity to deduct must be positive and available in inventory.
     *
     * @param inventoryItem Inventory item to deduct quantity from
     * @return ResponseEntity with success message or error message
     */
    @PostMapping("/deduct")
    public ResponseEntity<String> deductInventory(@RequestBody InventoryItem inventoryItem) {
        try {
            inventoryService.deductInventory(inventoryItem.getProductId(), inventoryItem.getQuantity());
            return ResponseEntity.ok("Inventory deducted successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to deduct inventory.");
        }
    }

    /**
     * Endpoint to add inventory quantity for a given product.
     *
     * Request method: POST
     * Endpoint: /inventory/add
     * Request body format: {"productId": "product_id", "quantity": quantity}
     * Response format: Success message or error message
     * Transaction validation rules: Quantity to add must be positive.
     *
     * @param inventoryItem Inventory item to add quantity to
     * @return ResponseEntity with success message or error message
     */
    @PostMapping("/add")
    public ResponseEntity<String> addInventory(@RequestBody InventoryItem inventoryItem) {
        try {
            inventoryService.addInventory(inventoryItem.getProductId(), inventoryItem.getQuantity());
            return ResponseEntity.ok("Inventory added successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add inventory.");
        }
    }
}

