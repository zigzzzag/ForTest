package com.mnikiforov.core.finaltest;

import org.junit.Assert;
import org.junit.Test;

public class FinalTest {

    @Test
    public void staticFinalTest() {
        Assert.assertEquals("A:staticFinalMethod", A.staticFinalMethod());
        Assert.assertEquals("A:staticMethodOnlyA", A.staticMethodOnlyA());
        Assert.assertEquals("A:staticMethodInAB", A.staticMethodInAB());

        Assert.assertEquals("B:staticMethodInAB", B.staticMethodInAB());
        Assert.assertEquals("A:staticMethodOnlyA", B.staticMethodOnlyA());
    }
}
