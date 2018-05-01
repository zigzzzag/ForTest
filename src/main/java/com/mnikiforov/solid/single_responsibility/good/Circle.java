package com.mnikiforov.solid.single_responsibility.good;

public class Circle extends GoodFigure {

    private final int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public String draw() {
        return "This is circle draw!!! radius = " + radius;
    }
}
