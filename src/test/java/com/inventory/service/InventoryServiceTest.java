package com.inventory.service;

import com.inventory.model.InventoryItem;
import com.inventory.repository.InventoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class InventoryServiceImplTest {

    @Mock
    private InventoryRepository inventoryRepository;

    @InjectMocks
    private InventoryServiceImpl inventoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testDeductInventoryInsufficientQuantity() {
        // Given
        String productId = "p001";
        int quantity = 10;
        InventoryItem inventoryItem = new InventoryItem(productId, 5);
        when(inventoryRepository.findByProductId(productId)).thenReturn(inventoryItem);

        // When and Then
        assertThrows(IllegalArgumentException.class, () -> inventoryService.deductInventory(productId, quantity));
        verify(inventoryRepository, never()).update(any());
    }

    @Test
    void testAddInventoryNewProduct() {
        // Given
        String productId = "p002";
        int quantity = 10;
        when(inventoryRepository.findByProductId(productId)).thenReturn(null);

        // When
        inventoryService.addInventory(productId, quantity);

        // Then
        verify(inventoryRepository, times(1)).save(any());
    }
}
