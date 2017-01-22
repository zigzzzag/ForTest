package com.mnikiforov.multithreading.sometasks;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zigzzzag on 22.01.2017.
 */
public class AtomicCounterTutor {

    //    int counter = 0;
    final AtomicInteger counter = new AtomicInteger();

    class TestThread implements Runnable {
        String threadName;

        public TestThread(String threadName) {
            this.threadName = threadName;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10_000; i++) {
//                counter++;
                counter.incrementAndGet();
                Thread.yield();
            }
        }
    }

    @Test
    public void testThread() {
        List<Thread> threads = new ArrayList<Thread>();
        for (int i = 0; i < 100; i++) {
            threads.add(new Thread(new TestThread("t" + i)));
        }
        System.out.println("Starting threads");
        for (Thread t : threads) {
            t.start();
        }
        try {
            for (Thread t : threads) {
                t.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Counter=" + counter);

    }
}
