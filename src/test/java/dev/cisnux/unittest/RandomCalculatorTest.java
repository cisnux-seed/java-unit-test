package dev.cisnux.unittest;

import dev.cisnux.unittest.data.Rectangle;
import dev.cisnux.unittest.resolver.RandomParameterResolver;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Random;

@Extensions(value = {@ExtendWith(RandomParameterResolver.class)})
public class RandomCalculatorTest extends AbstractCalculatorTest {
    // it will be fine
    @Test
    public void testRandom(TestInfo testInfo, Random random) {
        final var length = random.nextDouble() + 20;
        final var width = random.nextDouble() + 20;
        final var rectangle = new Rectangle(length, width);
        final var expected = length * width;
        assertEquals(expected, calculator.getArea(rectangle));
    }

    @RepeatedTest(value = 10, name = "{displayName} to {currentRepetition} of {totalRepetitions}")
    public void testRandomRepeat(TestInfo testInfo, Random random) {
        final var length = random.nextDouble() + 20;
        final var width = random.nextDouble() + 20;
        final var rectangle = new Rectangle(length, width);
        final var expected = length * width;
        assertEquals(expected, calculator.getArea(rectangle));
    }

    @RepeatedTest(value = 10, name = "{displayName}")
    public void testRandomRepeatInfo(TestInfo testInfo, RepetitionInfo repetitionInfo, Random random) {
        System.out.println(testInfo.getDisplayName() + " to " + repetitionInfo.getCurrentRepetition() + " of " + repetitionInfo.getTotalRepetitions());
        final var length = random.nextDouble() + 20;
        final var width = random.nextDouble() + 20;
        final var rectangle = new Rectangle(length, width);
        final var expected = length * width;
        assertEquals(expected, calculator.getArea(rectangle));
    }

    @DisplayName("Test calculator")
    @ParameterizedTest(name = "{displayName} with parameter {0}")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    public void testWithParameter(int value) {
        final var rectangle = new Rectangle(value, value);
        final var expected = value * value;
        assertEquals(expected, calculator.getArea(rectangle));
    }

    public static List<Rectangle> rectangleList() {
        return List.of(new Rectangle(4, 5), new Rectangle(3, 2), new Rectangle(4, 7), new Rectangle(5, 6), new Rectangle(5, 5));
    }

    @DisplayName("Test calculator")
    @ParameterizedTest(name = "{displayName} with parameter {0}")
    @MethodSource(value = "rectangleList")
    public void testWithMethodSource(Rectangle rectangle) {
        final var expected = rectangle.length() * rectangle.width();
        assertEquals(expected, calculator.getArea(rectangle));
    }
}
