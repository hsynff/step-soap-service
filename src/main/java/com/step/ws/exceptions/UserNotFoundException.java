package com.step.ws.exceptions;

public class UserNotFoundException extends Exception {
    private String message;
    private int code;

    public UserNotFoundException(String message, int code){
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }


}
