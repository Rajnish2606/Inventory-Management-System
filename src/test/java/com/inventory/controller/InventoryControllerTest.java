package com.inventory.controller;

import com.inventory.model.InventoryItem;
import com.inventory.service.InventoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class InventoryControllerTest {

    @Mock
    private InventoryService inventoryService;

    @InjectMocks
    private InventoryController inventoryController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testDeductInventory() {
        // Given
        String productId = "p001";
        int quantity = 5;
        //when(inventoryService.deductInventory(productId, quantity)).thenReturn(true);

        // When
        //ResponseEntity<?> responseEntity = inventoryController.deductInventory(productId, quantity);

        // Then
       // assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void testAddInventory() {
        // Given
        String productId = "p002";
        int quantity = 10;
        //when(inventoryService.addInventory(productId, quantity)).thenReturn(true);

        // When
        //ResponseEntity<?> responseEntity = inventoryController.addInventory(productId, quantity);

        // Then
        //assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}

