package com.gam.testdouble.stub;

public class LoginResponse {

    public static final String LOGIN_FAILIER_MESSAGE = "failed";
    public static final String LOGIN_SUCCESS_MESSAGE = "success";

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
