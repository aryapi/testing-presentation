package com.gam.testdouble.stub.solution;

import com.gam.testdouble.stub.LoginRequest;
import com.gam.testdouble.stub.LoginResponse;
import com.gam.testdouble.stub.LoginService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginServiceTest {

    private LoginService loginService;

    @BeforeEach
    void setUp() {
        loginService = new LoginService(new RejectingAuthorizerStub());
    }

    @Test
    void login_whenGivenBadCredential_shouldReturnLoginResponseWithFailureMessage() {
        LoginResponse response = loginService.login(createBadCredential());
        assertEquals(LoginResponse.LOGIN_FAILIER_MESSAGE, response.getMessage());
    }

    private LoginRequest createBadCredential() {
        return new LoginRequest("bad_user", "bad_pass");
    }
}