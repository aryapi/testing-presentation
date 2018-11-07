package com.gam.testdouble.spy;

public class InvalidUserId extends UserId {

    public InvalidUserId() {
        super(-1);
    }

    @Override
    boolean isValid() {
        return false;
    }
}
