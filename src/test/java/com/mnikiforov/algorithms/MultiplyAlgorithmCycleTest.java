package com.mnikiforov.algorithms;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class MultiplyAlgorithmCycleTest {

    private static final int ITERATION_COUNT = 10_000;
    private static final int THREAD_COUNT = 8;
    private final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);

    private final MultiplyAlgorithm normalMultiply = new NormalMultiply();
    private final MultiplyAlgorithm columnMultiply = new ColumnMultiply();

    @Test
    public void test() throws InterruptedException {
        for (int i = 1; i < ITERATION_COUNT; i += ITERATION_COUNT / THREAD_COUNT) {
            int finalI = i;
            executorService.execute(() -> multiplyTest(finalI, finalI + ITERATION_COUNT / THREAD_COUNT));
        }
        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    }

    private void multiplyTest(int start, int end) {
        System.out.println(Thread.currentThread().getName() + "; start = " + start + ", end = " + end);

        for (int i = start; i < end; i++) {
            for (int j = 1; j < ITERATION_COUNT; j++) {
                String expected = normalMultiply.multiply(i, j);
                String actual = columnMultiply.multiply(i, j);
                try {
                    assertEquals(expected, actual);
                } catch (AssertionError er) {
                    System.out.println("i = " + i + ", j = " + j);
                    throw er;
                }
            }

            if (i % (ITERATION_COUNT / 100) == 0) {
                System.out.println((Thread.currentThread().getName() + "; Progress: " + i + " iterations");
            }
        }
    }
}
