package com.mnikiforov.algorithms;

import java.math.BigDecimal;

public class NormalMultiply implements MultiplyAlgorithm {

    @Override
    public String multiplay(String arg1, String arg2) {
        BigDecimal d1 = new BigDecimal(arg1);
        BigDecimal d2 = new BigDecimal(arg2);

        BigDecimal res = d1.multiply(d2);

        return res.toString();
    }
}
