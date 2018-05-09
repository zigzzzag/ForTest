package com.mnikiforov.solid.c_liskov_substitution.bad;

import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class BadRectangleTest {

    @Test
    public void areaRectangle() {
        BadRectangle badRectangle = new BadRectangle();
        badRectangle.setWidth(5);
        badRectangle.setHeight(4);

        BadRectangle square = new BadSquare();
        square.setWidth(5);
        square.setHeight(4);

        assertNotEquals(square.area(), badRectangle.area());
    }
}