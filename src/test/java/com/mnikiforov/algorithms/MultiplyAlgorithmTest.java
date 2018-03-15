package com.mnikiforov.algorithms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class MultiplyAlgorithmTest {

    private final MultiplyAlgorithm multiplyAlgorithm;

    public MultiplyAlgorithmTest(MultiplyAlgorithm multiplyAlgorithm) {
        this.multiplyAlgorithm = multiplyAlgorithm;
    }

    @Parameters
    public static Collection<Object[]> getImplementations() {
        return Arrays.asList(new Object[][]{
                {new NormalMultiply()},
                {new ColumnMultiply()}
        });
    }

    @Test
    public void multiplyTest() {
        assertEquals("4", multiplyAlgorithm.multiply("2", "2"));
        assertEquals("121", multiplyAlgorithm.multiply("11", "11"));
        assertEquals("251460", multiplyAlgorithm.multiply("635", "396"));
        assertEquals("18415", multiplyAlgorithm.multiply("635", "29"));
        assertEquals("12333321", multiplyAlgorithm.multiply("111111", "111"));
        assertEquals("1219326311126352690", multiplyAlgorithm.multiply("1234567890", "987654321"));
    }
}
