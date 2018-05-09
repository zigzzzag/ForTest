package com.mnikiforov.solid.c_liskov_substitution.good;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GoodFigureTest {

    @Test
    public void area() {
        GoodFigure rect = new GoodRectangle(4, 5);
        assertEquals(20, rect.area());

        GoodFigure square = new GoodSquare(5);
        assertEquals(25, square.area());
    }
}