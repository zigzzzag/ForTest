package com.mnikiforov.testing_sber.t2016.c8_multithreading;

/**
 * Created by zigzzzag on 10/20/16.
 */
public class JoinTest {

    public static void main(String[] args) throws InterruptedException {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("2. start thread " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("3. finish thread " + Thread.currentThread().getName());
            }
        };

        // with t.join
        {
            System.out.println("1. start JoinTest");
            Thread t = new Thread(r);
            t.start();
            t.join();
            System.out.println("4. finish JoinTest");
        }

        System.out.println();
        System.out.println();

        // without t.join
        {
            System.out.println("1. start JoinTest");
            Thread t = new Thread(r);
            t.start();
            System.out.println("4. finish JoinTest");
        }
    }
}
