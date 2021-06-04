package com.molodyko.spring_rest.exception_handler;

public class NoSuchEmployee extends RuntimeException{

    public NoSuchEmployee(String message) {
        super(message);
    }
}
