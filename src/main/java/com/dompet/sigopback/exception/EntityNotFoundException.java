package com.dompet.sigopback.exception;

public class EntityNotFoundException extends  RuntimeException{
    public EntityNotFoundException() {
    }

    public EntityNotFoundException(String message) {
        super(message);
    }
}
