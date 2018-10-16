package com.gam.e01;

import org.junit.jupiter.api.*;

class JunitAnnotations {

    @BeforeAll
    static void beforeAll() {
        System.out.println("before all");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("after all");
    }

    @BeforeEach
    void setUp() {
        System.out.println("before each");
    }

    @AfterEach
    void tearDown() {
        System.out.println("after each");
    }

    @Test
    @DisplayName("sample test")
    void sampleTest() {
        System.out.println("sample test");
    }

    @Test
    void anotherSampleTest() {
        System.out.println("another sample test");
    }
}
