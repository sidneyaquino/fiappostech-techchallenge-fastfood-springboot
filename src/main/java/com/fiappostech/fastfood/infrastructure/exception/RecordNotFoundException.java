package com.fiappostech.fastfood.infra.exception;

import java.util.UUID;

public class RecordNotFoundException extends RuntimeException {

    public RecordNotFoundException(Long id) {
        super(message(id));
    }

    public RecordNotFoundException(UUID id) {
        super(message(id));
    }

    private static String message(Object id){
        return String.format("Unable to find record with id %s", id.toString());
    }
}