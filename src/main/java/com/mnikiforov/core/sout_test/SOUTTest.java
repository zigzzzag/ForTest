package com.mnikiforov.core.sout_test;

/**
 * Created by SBT-Nikiforov-MO on 24.09.2015.
 */
public class SOUTTest {
    private static final int ITER_COUNT = 100;

    public static void main(String[] args) {
        for (int i = 0; i < ITER_COUNT; i++) {
            System.out.println("out: " + i);
            System.err.println("err: " + i);
        }
    }
}
