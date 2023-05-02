package com.UST.SamplePractice.exception;

public class NameNotFoundException extends RuntimeException{
    public NameNotFoundException(String message){
        super(message);
    }
}
