package dev.cisnux.unittest;

import dev.cisnux.unittest.resolver.RandomParameterResolver;
import org.junit.jupiter.api.BeforeEach;

public abstract class AbstractCalculatorTest {
    protected final Calculator calculator = new Calculator();

    @BeforeEach
    void setUp() {
        System.out.println("before each");
    }
}
