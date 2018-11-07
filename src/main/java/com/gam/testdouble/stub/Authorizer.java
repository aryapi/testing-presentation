package com.gam.testdouble.stub;

public interface Authorizer {

    UserId authorize(String username, String password);
}
