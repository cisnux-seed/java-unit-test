package dev.cisnux.unittest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

public class ConditionTest {
    @Test
    public void testSystemProperties() {
        System.getProperties().forEach((o, o2) -> System.out.printf("%s: %s\n", o, o2));
    }

    @Test
    @EnabledOnOs(value = {OS.MAC})
    public void onlyRunOnMac() {

    }

    @Test
    @DisabledOnOs(value = {OS.MAC})
    public void disabledRunOnMac() {
    }

    @Test
    @EnabledOnJre(value = {JRE.JAVA_21})
    public void onlyRunOnJava21() {

    }

    @Test
    @DisabledOnJre(value = {JRE.JAVA_21})
    public void disabledRunOnJava21() {
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_21)
    public void onlyRunOnJava11ToJava21() {
    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_21)
    public void disabledRunOnJava11ToJava21() {
    }

    @Test
    @EnabledIfSystemProperty(named = "java.vendor", matches = "Amazon.com Inc.")
    public void enableOnAmazon() {

    }

    @Test
    @DisabledIfSystemProperty(named = "java.vendor", matches = "Amazon.com Inc.")
    public void disabledOnAmazon() {

    }

    @Test
    @EnabledIfEnvironmentVariables(value = @EnabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV"))
    public void enableOnDev() {

    }

    @Test
    @DisabledIfEnvironmentVariables(value = @DisabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV"))
    public void disabledOnDev() {

    }
}
