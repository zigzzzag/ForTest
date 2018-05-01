package com.mnikiforov.solid.single_responsibility.bad;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BadGeometricFigureTest {

    @Test
    public void area() {
        BadGeometricFigure rectangle = new BadGeometricFigure(2, 3);
        assertEquals(6, rectangle.area(), 0.01);

        BadGeometricFigure circle = new BadGeometricFigure(2);
        assertEquals(12.56, circle.area(), 0.01);
    }

    @Test
    public void draw() {
        BadGeometricFigure rectangle = new BadGeometricFigure(7, 3);
        System.out.println(rectangle.draw());

        BadGeometricFigure circle = new BadGeometricFigure(2);
        assertEquals("This is circle draw!!! radius = 2", circle.draw());
    }

    @Test
    public void getUuid() {
        BadGeometricFigure rectangle = new BadGeometricFigure(2, 3);
        assertNotNull(rectangle.getUuid());
    }
}