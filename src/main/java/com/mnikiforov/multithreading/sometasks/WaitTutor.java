package com.mnikiforov.multithreading.sometasks;

import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;

/**
 * Created by zigzzzag on 22.01.2017.
 * <p>
 * Как сделать так, чтобы потоки вызывались по очереди?
 * <p>
 * Часто необходимо упорядочить потоки, т.к. результат одного потока
 * понадобится другому, и нужно дождаться, когда первый поток сделает свою работу.
 * <p>
 * Задача: добавьте еще один поток, который будет выводить в лог сообщения о
 * значениях счетчика, кратных 10, например 10, 20, 30...
 * При этом такие сообщения должны выводиться после того, как все потоки преодолели
 * кратность 10, но до того, как какой-либо поток двинулся дальше.
 */
public class WaitTutor {

    private static final int MAIN_ITERATE_COUNT = 100_000;

    final Object monitor = new Object();
    AtomicInteger runningThreadNumber = new AtomicInteger(3);
    AtomicInteger t1Counter = new AtomicInteger();
    AtomicInteger t2Counter = new AtomicInteger();
//    int t1Counter = 0;
//    int t2Counter = 0;
    //int maxCounter = 0;

    class TestThread implements Runnable {
        String threadName;
        int n;

        public TestThread(String threadName, int n) {
            this.threadName = threadName;
            this.n = n;
        }

        @Override
        public void run() {
            for (int i = 1; i < MAIN_ITERATE_COUNT; i++) {
                synchronized (monitor) {
                    while (n != runningThreadNumber.get()) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.err.println(threadName + ":" + i);

                    if (n == 1) t1Counter.set(i);
                    if (n == 2) t2Counter.set(i);
//                    if (n == 1) t1Counter = i;
//                    if (n == 2) t2Counter = i;


//                    monitor.notify();
//                    Thread.yield();

                    if (t1Counter.get() % 10 == 0 && t2Counter.get() % 10 == 0) {
//                    if (t1Counter % 10 == 0 && t2Counter % 10 == 0) {
                        runningThreadNumber.set(3);
                    } else {
//                    try {
                        if (n == 1) {
//                        if (i > t2Counter) {
//                            System.out.println("t1 is ahead with i=" + i + ", wait for t2Counter=" + t2Counter);
//                                monitor.wait();
//                        }
                            runningThreadNumber.set(2);
                        } else if (n == 2) {
//                        if (i < t1Counter) {
//                            System.out.println("t2 is ahead with i=" + i + ", wait for t1Counter=" + t1Counter);
//                                monitor.wait();
//                        }
                            runningThreadNumber.set(1);
                        }
                    }
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    monitor.notifyAll();
                }
//                Thread.yield();
            }
        }
    }

    /**
     * будет выводить в лог сообщения о
     * значениях счетчика, кратных 10, например 10, 20, 30...
     * При этом такие сообщения должны выводиться после того, как все потоки преодолели
     * кратность 10, но до того, как какой-либо поток двинулся дальше.
     */
    class MyltiplicityRunner implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < MAIN_ITERATE_COUNT / 10; i++) {
                synchronized (monitor) {
                    while (runningThreadNumber.get() != 3) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.err.println("MyltiplicityRunner: t1Counter=" + t1Counter + ", t2Counter" + t2Counter);
                    runningThreadNumber.set(1);
                    monitor.notifyAll();
                }
            }
        }
    }

    @Test
    public void testThread() {
        long start = System.currentTimeMillis();

        Thread t1 = new Thread(new TestThread("t1", 1));
        Thread t2 = new Thread(new TestThread("t2", 2));
        Thread t3 = new Thread(new MyltiplicityRunner());
        System.err.println("Starting threads");
        t1.start();
        t2.start();
        t3.start();

        System.err.println("Waiting for threads");
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.err.println("FULL TIME: " + (System.currentTimeMillis() - start) + "ms");
    }
}
