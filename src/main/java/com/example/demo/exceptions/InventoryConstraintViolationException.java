package com.example.demo.exceptions;

public class InventoryConstraintViolationException extends RuntimeException {
    public InventoryConstraintViolationException(String message) {
        super(message);
    }
}
