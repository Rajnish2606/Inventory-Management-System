package com.inventory.model;

import java.time.LocalDateTime;

public class InventoryTransaction {

    private String transactionId;
    private String productId;
    private int quantity;
    private TransactionType transactionType;
    private LocalDateTime timestamp;

    public InventoryTransaction() {
    }

    public InventoryTransaction(String transactionId, String productId, int quantity, TransactionType transactionType, LocalDateTime timestamp) {
        this.transactionId = transactionId;
        this.productId = productId;
        this.quantity = quantity;
        this.transactionType = transactionType;
        this.timestamp = timestamp;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "InventoryTransaction{" +
                "transactionId='" + transactionId + '\'' +
                ", productId='" + productId + '\'' +
                ", quantity=" + quantity +
                ", transactionType=" + transactionType +
                ", timestamp=" + timestamp +
                '}';
    }
}

