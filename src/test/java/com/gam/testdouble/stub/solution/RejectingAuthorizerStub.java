package com.gam.testdouble.stub.solution;

import com.gam.testdouble.stub.Authorizer;
import com.gam.testdouble.stub.InvalidUserId;
import com.gam.testdouble.stub.UserId;

public class RejectingAuthorizerStub implements Authorizer {
    @Override
    public UserId authorize(String username, String password) {
        return new InvalidUserId();
    }
}
