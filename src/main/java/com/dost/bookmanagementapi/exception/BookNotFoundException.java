package com.dost.bookmanagementapi.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException (String errMessage) {
        super(errMessage);
    }
}
