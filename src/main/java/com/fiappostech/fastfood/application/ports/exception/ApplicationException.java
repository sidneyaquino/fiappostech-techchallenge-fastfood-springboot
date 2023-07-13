package com.fiappostech.fastfood.application.ports.exception;

public class ApplicationException extends RuntimeException {

    public ApplicationException(String message) {
        super(message);
    }
}