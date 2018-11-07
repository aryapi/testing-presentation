package com.gam.testdouble.spy;

import java.sql.Timestamp;

public class AuthorizerImpl implements Authorizer {

    public static final String ACTION_CODE = "GAM_AUT_001";
    private UserGateway userGateway;
    private AuditLog auditLog;

    public AuthorizerImpl(UserGateway userGateway, AuditLog auditLog) {
        this.userGateway = userGateway;
        this.auditLog = auditLog;
    }

    @Override
    public UserId authorize(Credential credential) {
        User user = userGateway.findByUsername(credential.getUsername());
        if (!user.isValidPassword(credential.getPassword()))
            return new InvalidUserId();

        auditLog.log(new Timestamp(System.currentTimeMillis()),
                user.getUsername(), ACTION_CODE, user.getId());
        return new UserId(user.getId());
    }
}
