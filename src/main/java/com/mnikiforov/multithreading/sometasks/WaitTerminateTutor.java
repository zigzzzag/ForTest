package com.mnikiforov.multithreading.sometasks;

import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.Test;

/**
 * Как остановить поток?
 * <p>
 * Для того,чтобы прервать поток,мы можем использовать флаг
 * shouldTerminate,который должен проверяться в цикле внутри run().
 * Если флаг становится true,мы просто выходим из цикла.
 * <p>
 * Однако,тут могут быть проблемы,если от нашего потока зависят другие потоки.
 * В настоящий момент поток t2 прерывается,и программа подвисает,
 * т.к.поток t1 ждет второй поток и не может дождаться.
 * Какие есть решения проблемы?
 */

public class WaitTerminateTutor {

    Thread t1, t2;
    final Object monitor = new Object();
    int runningThreadNumber = 1;
    public AtomicBoolean shouldTerminate = new AtomicBoolean();

    class TestThread implements Runnable {
        String threadName;

        public TestThread(String threadName) {
            this.threadName = threadName;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println("Thread " + threadName + " started work: " + i);
                synchronized (monitor) {
                    try {
                        while (!shouldTerminate.get() && !threadName.equals("t" + runningThreadNumber)) {
                            System.out.println("wait for thread " + "t" + runningThreadNumber);
                            monitor.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    runningThreadNumber++;
                    if (runningThreadNumber > 2) runningThreadNumber = 1;
                    monitor.notifyAll();
                    try {
                        Thread.sleep(100);
                        System.out.println("Thread " + threadName + " finished work: " + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (shouldTerminate.get()) return;
                }
            }
        }
    }

    @Test
    public void testThread() {
        TestThread testThread1 = new TestThread("t1");
        t1 = new Thread(testThread1);
        final TestThread testThread2 = new TestThread("t2");
        t2 = new Thread(testThread2);
        System.out.println("Starting threads...");
        t1.start();
        t2.start();

        Thread terminator = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (monitor) {
                    System.out.println("Terminator: shouldTerminate = true");
                    shouldTerminate.set(true);
                    monitor.notifyAll();
                }
            }
        });
        terminator.start();

        System.out.println("Waiting threads to join...");
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
