package com.gam.testdouble.spy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthorizerImplTest {

    private AuthorizerImpl authorizer;
    private AuditLogSpy auditLogSpy;
    private static final Credential VALID_CREDENTIAL = ObjectMother.createValidCredential();

    @BeforeEach
    void setUp() {
        auditLogSpy = new AuditLogSpy();
        authorizer = new AuthorizerImpl(new UserGatewayStub(), auditLogSpy);
    }

    @Test
    void authorize_whenGivenValidCredential_shouldAuditLogUserIdAsDetailAndCorrectActionCode() {
        authorizer.authorize(VALID_CREDENTIAL);
        assertEquals(TestHelper.VALID_USERNAME, auditLogSpy.getUsername());
        assertEquals(AuthorizerImpl.ACTION_CODE, auditLogSpy.getActionCode());
        assertEquals(TestHelper.VALID_USER_ID, auditLogSpy.getDetail());
    }

}