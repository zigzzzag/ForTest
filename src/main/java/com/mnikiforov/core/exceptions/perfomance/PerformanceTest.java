package com.mnikiforov.core.exceptions.perfomance;

/**
 * Created by sbt-nikiforov-mo on 07.07.16.
 */
public class PerformanceTest {
    private static final int COUNT_ITER = 1_000_000;

    public static void main(String[] args) {
        PerformanceTest pt = new PerformanceTest();

        long checkFullTime = 0L;
        for (int i = 0; i < COUNT_ITER; i++) {
            long start = System.nanoTime();
            pt.checkNull();
            checkFullTime += System.nanoTime() - start;
        }
        System.out.println("check: " + checkFullTime / 1_000_000 + "ms");


        long catchFullTime = 0L;
        for (int i = 0; i < COUNT_ITER; i++) {
            long start = System.nanoTime();
            pt.catchNPE();
            catchFullTime += System.nanoTime() - start;
        }
        System.out.println("catch: " + catchFullTime / 1_000_000 + "ms");
    }

    private void catchNPE() {
        String s = null;
        try {
            s.isEmpty();
        } catch (NullPointerException npe) {
//            System.out.println("npe catched");
        }
    }

    private void checkNull() {
        String s = null;
        if (s != null) {
            s.isEmpty();
        } else {
//            System.out.println("check on null");
        }
    }
}
