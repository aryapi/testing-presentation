package com.gam.e02;

import org.junit.jupiter.api.Test;

class TestInIsolation {

    private int counter = 0;

    @Test
    void testOne() {
        System.out.println("test one, counter: " + ++counter);
    }

    @Test
    void testTwo() {
        System.out.println("test two, counter: " + ++counter);
    }

    @Test
    void testThree() {
        System.out.println("test three, counter: " + ++counter);
    }
}
