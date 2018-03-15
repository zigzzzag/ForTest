package com.mnikiforov.algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ColumnMultiplyTest {
    private final MultiplyAlgorithm multiplyAlgorithm = new ColumnMultiply();

    @Test
    public void multiplyTest() {
        assertEquals("4", multiplyAlgorithm.multiply("2", "2"));
        assertEquals("121", multiplyAlgorithm.multiply("11", "11"));
        assertEquals("251460", multiplyAlgorithm.multiply("635", "396"));
        assertEquals("18415", multiplyAlgorithm.multiply("635", "29"));
        assertEquals("1219325201126352690", multiplyAlgorithm.multiply("1234567890", "987654321"));
    }
}
