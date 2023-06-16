package com.example.payment.ecxeptions;

public class NoPersonAddedException extends RuntimeException{
    public NoPersonAddedException() {
    }

    public NoPersonAddedException(String message) {
        super(message);
    }
}
