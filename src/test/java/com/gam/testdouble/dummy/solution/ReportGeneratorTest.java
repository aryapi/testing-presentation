package com.gam.testdouble.dummy.solution;

import com.gam.testdouble.dummy.ReportGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ReportGeneratorTest {

    private ReportGenerator generator;

    @BeforeEach
    void setUp() {
        generator = new ReportGenerator();
    }

    @ParameterizedTest
    @ValueSource(ints = {-5, 0, 13, 123989})
    void generateMonthlyReport_whenGivenMountIsNotValid_shouldThrowInvalidDateException(int invalidMountNumber) {
        assertThrows(ReportGenerator.InvalidDateException.class,
                () -> generator.generateMonthlyReport(invalidMountNumber, new DummySession()));
    }
}