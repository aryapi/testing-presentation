package com.gam.testdouble.spy;

import java.sql.Timestamp;

public class AuditLogSpy implements AuditLog {

    private String username;
    private String actionCode;
    private Object detail;

    @Override
    public void log(Timestamp date, String username, String actionCode, Object detail) {
        this.username = username;
        this.actionCode = actionCode;
        this.detail = detail;
    }

    public String getUsername() {
        return username;
    }

    public String getActionCode() {
        return actionCode;
    }

    public Object getDetail() {
        return detail;
    }
}
