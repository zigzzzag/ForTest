package com.mnikiforov.solid.single_responsibility.good;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CircleTest {

    @Test
    public void area() {
        GoodFigure circle = new Circle(2);
        assertEquals(12.56, circle.area(), 0.01);
    }

    @Test
    public void draw() {
        GoodFigure circle = new Circle(7);
        assertEquals("This is circle draw!!! radius = 7", circle.draw());
    }

    @Test
    public void getUuid() {
        GoodFigure circle = new Circle(3);
        assertNotNull(circle.getUuid());
    }
}