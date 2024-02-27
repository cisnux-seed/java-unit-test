package dev.cisnux.unittest;

import org.junit.jupiter.api.*;

@Tags(value = {@Tag("integrations-test")})
public class SampleIntegrationTest {

    @Test
    void integrationTest1() {
        System.out.println("Integration Test 1");
    }

    @Test
    void integrationTest2() {
        System.out.println("Integration Test 2");
    }
}
