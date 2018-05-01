package com.mnikiforov.solid.single_responsibility.good;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RectangleTest {

    @Test
    public void area() {
        GoodFigure rectangle = new Rectangle(2, 3);
        assertEquals(6, rectangle.area(), 0.01);
    }

    @Test
    public void draw() {
        GoodFigure rectangle = new Rectangle(7, 3);
        System.out.println(rectangle.draw());
    }

    @Test
    public void getUuid() {
        GoodFigure rectangle = new Rectangle(7, 3);
        assertNotNull(rectangle.getUuid());
    }
}