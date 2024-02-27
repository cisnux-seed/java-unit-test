package dev.cisnux.unittest;

import dev.cisnux.unittest.data.Rectangle;
import dev.cisnux.unittest.generator.SimpleDisplayNameGenerator;
import org.junit.jupiter.api.*;
import org.opentest4j.TestAbortedException;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@DisplayName("Test Calculator")
@DisplayNameGeneration(value = SimpleDisplayNameGenerator.class)
class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @BeforeEach
    void setUp() {
        System.out.println("Before unit test");
    }

    @AfterEach
    void tearDown() {
        System.out.println("After unit test");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before all");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After all");
    }

    @Test
    @DisplayName("Test Method Calculator.area(double, double)")
    public void testAreaSuccess() {
        final var area = calculator.getArea(2, 3);
        final var expected = 6.0;
        assertEquals(expected, area);
    }

    @Test
    public void testAreaSuccessForRectangle() {
        final var rectangle = new Rectangle(3, 3);
        final var area = calculator.getArea(rectangle);
        final var expected = 9.0;
        assertEquals(expected, area);
    }

    @Test
    public void testDivideSuccess() {
        final var result = calculator.divide(3, 2);
        final var expected = 1.5;
        assertEquals(expected, result);
    }

    @Test
    public void testDivideError() {
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(2, 0));
    }

    @Disabled
    @Test
    void testComingSoon() {
        // TODO coming soon!
    }

    @Test
    void testAborted() {
        final var profile = System.getenv("PROFILE");
        if (!"DEV".equals(profile))
            throw new TestAbortedException();
        // dev unit test
    }

    @Test
    void testAssumption() {
        assumeTrue("DEV".equals(System.getenv("PROFILE")));
        // dev unit test
    }
}