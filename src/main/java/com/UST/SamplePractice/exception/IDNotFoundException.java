package com.UST.SamplePractice.exception;

public class IDNotFoundException extends RuntimeException{
    public IDNotFoundException(String message) {
        super(message);
    }
}
