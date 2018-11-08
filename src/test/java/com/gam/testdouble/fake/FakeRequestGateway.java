package com.gam.testdouble.fake;

import com.gam.testdouble.mock.ReportManagerRequestGateway;

public class FakeRequestGateway implements ReportManagerRequestGateway {

    public static byte[] REPORT_BYTES = new byte[0];
    public static final long RUNNING_FOR_EVER_ID = 1;
    public static final long CREATED_AFTER_5_CALL = 2;

    private int getStatusCalledCounter;

    @Override
    public String getReportStatus(long reportId) {
        getStatusCalledCounter++;
        if (reportId == CREATED_AFTER_5_CALL && getStatusCalledCounter == 5)
            return "created";

        return "running";
    }

    @Override
    public byte[] getReportBytes(long reportId) {
        return REPORT_BYTES;
    }

    public int getGetStatusCalledCounter() {
        return getStatusCalledCounter;
    }
}
