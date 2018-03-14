package com.mnikiforov.algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NormalMultiplyTest {

    private final MultiplyAlgorithm multiplyAlgorithm = new NormalMultiply();

    @Test
    public void multiplyTest() {
        assertEquals("4", multiplyAlgorithm.multiplay("2", "2"));
        assertEquals("251460", multiplyAlgorithm.multiplay("635", "396"));
    }
}
