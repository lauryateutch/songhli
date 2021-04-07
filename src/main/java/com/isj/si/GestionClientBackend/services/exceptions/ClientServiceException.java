package com.isj.si.GestionClientBackend.services.exceptions;

import org.springframework.http.HttpStatus;

public class ClientServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private HttpStatus status;

    public ClientServiceException(String message) {
        super(message);
    }

    public ClientServiceException(String message, HttpStatus status) {
        super("[HTTP STATUS "+status+"] -"+message);
        this.status = status;
    }
}
