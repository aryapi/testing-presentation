package com.gam.testdouble.spy;

public class UserGatewayStub implements UserGateway {

    @Override
    public User findByUsername(String username) {
        return ObjectMother.createValidUser();
    }
}
