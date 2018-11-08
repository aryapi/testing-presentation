package com.gam.testdouble.mock;

public class ReportDownloader {
    static final int MAX_TRY = 10;

    private ReportManagerRequestGateway requestGateway;

    public ReportDownloader(ReportManagerRequestGateway requestGateway) {
        this.requestGateway = requestGateway;
    }

    public byte[] download(long reportId) {
        String status = requestGateway.getReportStatus(reportId);
        for (int tryCount = 1; isRunning(status) && tryCount <= MAX_TRY; tryCount++)
            status = requestGateway.getReportStatus(reportId);

        if (!isCreated(status))
            throw new ReportGeneratorException();

        return requestGateway.getReportBytes(reportId);
    }

    private boolean isRunning(String status) {
        return status.equals("running");
    }

    private boolean isCreated(String status) {
        return status.equals("created");
    }
}
