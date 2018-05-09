package com.mnikiforov.solid.c_liskov_substitution.good;

public class GoodSquare implements GoodFigure {

    private final int side;

    GoodSquare(int side) {
        this.side = side;
    }

    @Override
    public int area() {
        return side * side;
    }
}
