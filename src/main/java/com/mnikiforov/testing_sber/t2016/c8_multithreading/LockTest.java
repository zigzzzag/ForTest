package com.mnikiforov.testing_sber.t2016.c8_multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zigzzzag on 10/19/16.
 */
public class LockTest {

    public static void main(String[] args) throws InterruptedException {
        new LockTest().startTest();
    }

    private void startTest() {
        Lock lock = new ReentrantLock();

        TestRunnable tr1 = new TestRunnable(lock, "1");
        TestRunnable tr2 = new TestRunnable(lock, "2");

        new Thread(tr1).start();
        new Thread(tr2).start();
    }


    private class TestRunnable implements Runnable {

        final Lock lock;
        final String id;

        public TestRunnable(Lock lock, String id) {
            this.lock = lock;
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println("start " + id);
            lock.lock();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            System.out.println("stop " + id);
        }
    }
}
