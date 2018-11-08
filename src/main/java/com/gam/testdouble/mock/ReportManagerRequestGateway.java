package com.gam.testdouble.mock;

public interface ReportManagerRequestGateway {

    String getReportStatus(long reportId);

    byte[] getReportBytes(long reportId);
}
