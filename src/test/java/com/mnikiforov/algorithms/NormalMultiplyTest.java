package com.mnikiforov.algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NormalMultiplyTest {

    private final MultiplyAlgorithm multiplyAlgorithm = new NormalMultiply();

    @Test
    public void multiplyTest() {
        assertEquals("4", multiplyAlgorithm.multiply("2", "2"));
        assertEquals("251460", multiplyAlgorithm.multiply("635", "396"));
    }
}
