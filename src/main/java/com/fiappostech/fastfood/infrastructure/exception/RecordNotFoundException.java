package com.fiappostech.fastfood.infrastructure.exception;

public class RecordNotFoundException extends RuntimeException {

    public RecordNotFoundException(Object id) {
        super(message(id));
    }

    private static String message(Object id){
        return String.format("Unable to find record with id %s", id.toString());
    }
}