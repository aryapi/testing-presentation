package com.gam.testdouble.fake;

import com.gam.testdouble.mock.ReportDownloader;
import com.gam.testdouble.mock.ReportGeneratorException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReportDownloaderTest {

    private FakeRequestGateway fakeRequestGateway;
    private ReportDownloader reportDownloader;

    @BeforeEach
    void setUp() {
        fakeRequestGateway = new FakeRequestGateway();
        reportDownloader = new ReportDownloader(fakeRequestGateway);
    }

    @Test
    void download_whenReportStayInRunningStatus_shouldTryUntilMaxTryAndThrowReportGeneratorException() {
        assertThrows(ReportGeneratorException.class,
                () -> reportDownloader.download(FakeRequestGateway.RUNNING_FOR_EVER_ID));
        assertEquals(11, fakeRequestGateway.getGetStatusCalledCounter());
    }

    @Test
    void download_shouldReturnReportBytes() {
        assertEquals(FakeRequestGateway.REPORT_BYTES,
                reportDownloader.download(FakeRequestGateway.CREATED_AFTER_5_CALL));
        assertEquals(5, fakeRequestGateway.getGetStatusCalledCounter());
    }
}
