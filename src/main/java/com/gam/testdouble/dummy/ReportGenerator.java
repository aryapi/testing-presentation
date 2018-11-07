package com.gam.testdouble.dummy;

import java.util.Date;

@SuppressWarnings("unused")
public class ReportGenerator {

    public void generateMonthlyReport(int mount, Session session) {
        Date requestedDate = session.getRequestDate();

        if (!isValidMountNumber(mount))
            throw new InvalidDateException();

        // ...
    }

    private boolean isValidMountNumber(int mount) {
        return mount > 0 && mount <= 12;
    }

    public static class InvalidDateException extends RuntimeException {

    }
}
