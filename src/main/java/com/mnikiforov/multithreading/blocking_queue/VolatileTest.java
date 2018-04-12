package com.mnikiforov.multithreading.blocking_queue;

public class VolatileTest {

    /**
     * if remove volatile keyword then count in ReadThread will not change
     */
    private volatile static int count;

    public static void main(String[] args) {
        class ReadThread extends Thread {
            @Override
            public void run() {
                int countLocal = count;
                while (count < 10) {
                    if (countLocal < count) {
                        System.err.println("read count increment: " + count);
                        countLocal = count;
                    }
                }
            }
        }

        class WriteThread extends Thread {
            @Override
            public void run() {
                while (count < 10) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    count++;
                    System.err.println("write count increment: " + count);
                }
            }
        }

        new WriteThread().start();
        new ReadThread().start();
    }
}
