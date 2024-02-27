package dev.cisnux.unittest;

import org.junit.jupiter.api.*;

@DisplayName("Test with TestInfo")
public class InformationTest {

    @Test
    @Tag("cool")
    @DisplayName("this is first test")
    void name(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
        System.out.println(testInfo.getTags());
        System.out.println(testInfo.getTestMethod());
        System.out.println(testInfo.getTestClass());
    }
}
