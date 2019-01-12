package com.step.ws.constants;

public class MessageConstants {
    public static final String ERROR_USER_NOT_FOUND = "User not found";
    public static final String ERROR_INVALID_FIELDS = "One or more fields are invalidated";
    public static final String ERROR_INTERNAL = "Internal error";

    public static int errorCodeOf(String message){
        switch (message){
            case ERROR_USER_NOT_FOUND:
                return 100;
            case ERROR_INVALID_FIELDS:
                return 101;
            case ERROR_INTERNAL:
                return 102;
            default:
                return 102;
        }
    }
}
