package com.mnikiforov.multithreading.sometasks;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zigzag on 22.01.2017.
 */
public class ThreadsInOrder {

    final Object monitor = new Object();
    int runningThreadId = 0;

    @Test
    public void test() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            threads.add(new Thread(new TestRunnable(i)));
        }

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }
    }

    class TestRunnable implements Runnable {

        final int id;

        public TestRunnable(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            synchronized (monitor) {
                while (id != runningThreadId) {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                for (int i = 0; i < 3; i++) {
                    System.out.println("thread id=" + id + " : " + i);
                }

                runningThreadId++;
                monitor.notifyAll();
            }
        }
    }
}
