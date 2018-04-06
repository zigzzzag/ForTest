package com.mnikiforov.core.longTest;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongTestNullTest {

    @Test(expected = NullPointerException.class)
    public void compareWithNullTest() {
        Long l = null;
        assertFalse(1 == l);
    }
}