package com.mnikiforov.testing_sber.t2016.c8_multithreading;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zigzzzag on 10/20/16.
 */
public class CounterTest {

    private static final int ITER_COUNT = 100_000_000;
    static AtomicInteger counter = new AtomicInteger(0);

    static class Counter extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < ITER_COUNT; i++) {
                if (i % (ITER_COUNT / 100) == 0) {
                    System.out.println(Thread.currentThread().getName() + " i=" + i + " counter=" + counter);
                }
                counter.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter c1 = new Counter();
        Counter c2 = new Counter();

        c1.start();
        c2.start();

        c1.join();
        c2.join();

        System.out.println(counter);
    }
}
