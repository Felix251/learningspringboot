package com.example.learnspringboot.Exception;

import org.springframework.http.HttpStatus;

public class Apiexception extends RuntimeException {
    private HttpStatus httpStatus;
    private String messsage;
    private Throwable throwable;

    public Apiexception(String message, HttpStatus httpStatus, String messsage, Throwable throwable) {
        super(message);
        this.httpStatus = httpStatus;
        this.messsage = messsage;
        this.throwable = throwable;
    }
}
