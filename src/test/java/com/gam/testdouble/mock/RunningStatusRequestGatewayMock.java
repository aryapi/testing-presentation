package com.gam.testdouble.mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RunningStatusRequestGatewayMock implements ReportManagerRequestGateway {

    private int getStatusCalledCounter;

    @Override
    public String getReportStatus(long reportId) {
        getStatusCalledCounter++;
        return "running";
    }

    @Override
    public byte[] getReportBytes(long reportId) {
        return new byte[0];
    }

    public void verifyGetStatusCalled(int expectedTryCount) {
        assertEquals(expectedTryCount, getStatusCalledCounter);
    }
}
