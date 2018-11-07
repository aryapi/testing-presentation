package com.gam.testdouble.stub;

public class InvalidUserId extends UserId {

    @Override
    boolean isValid() {
        return false;
    }
}
