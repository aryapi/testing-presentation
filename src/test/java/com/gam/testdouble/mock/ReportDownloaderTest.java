package com.gam.testdouble.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ReportDownloaderTest {

    private RunningStatusRequestGatewayMock requestGatewayMock;
    private ReportDownloader reportDownloader;

    @BeforeEach
    void setUp() {
        requestGatewayMock = new RunningStatusRequestGatewayMock();
        reportDownloader = new ReportDownloader(requestGatewayMock);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 100, 12314})
    void download_whenReportStayInRunningStatus_shouldTryUntilMaxTry(int reportId) {
        assertThrows(ReportGeneratorException.class, () -> reportDownloader.download(reportId));
        requestGatewayMock.verifyGetStatusCalled(ReportDownloader.MAX_TRY + 1);
    }
}