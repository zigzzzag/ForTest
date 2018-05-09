package com.mnikiforov.solid.c_liskov_substitution.good;

public class GoodRectangle implements GoodFigure {

    private final int width;
    private final int height;

    GoodRectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int area() {
        return width * height;
    }
}
