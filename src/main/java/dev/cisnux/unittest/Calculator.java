package dev.cisnux.unittest;

import dev.cisnux.unittest.data.Rectangle;

final public class Calculator {
    public double getArea(double length, double width) {
        return length * width;
    }

    public double getArea(Rectangle rectangle) {
        return rectangle.length() * rectangle.width();
    }

    public double divide(double first, double second) {
        if (second == 0) {
            throw new IllegalArgumentException("Can not divide by zero");
        }
        return first / second;
    }
}
