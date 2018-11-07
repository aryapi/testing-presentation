package com.gam.testdouble.spy;

import java.sql.Timestamp;

public interface AuditLog {

    void log(Timestamp date, String user, String actionCode, Object detail);
}
