package com.mnikiforov.algorithms;

public interface MultiplyAlgorithm {

    String multiply(String arg1, String arg2);

    default String multiply(long arg1, long arg2) {
        return multiply(Long.toString(arg1), Long.toString(arg2));
    }
}
