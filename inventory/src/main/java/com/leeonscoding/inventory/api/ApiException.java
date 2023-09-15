package com.leeonscoding.inventory.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ApiException extends ResponseStatusException {
    private String message;

    public ApiException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
        this.message = message;
    }

    @Override
    public String toString() {
        return "ApiException{" +
                "message='" + message + '\'' +
                '}';
    }
}
