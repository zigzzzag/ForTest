package com.mnikiforov.testing_sber.t2016.c8_multithreading;

import java.util.concurrent.CountDownLatch;

/**
 * Created by zigzzzag on 10/20/16.
 */
public class AppendTest {

    static StringBuffer sb = new StringBuffer();

    static class MyThread extends Thread {

        final CountDownLatch latch;

        public MyThread(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 10_000; i++) {
                sb.append(getName());
                sb.append(";");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);

        MyThread thread1 = new MyThread(latch);
        MyThread thread2 = new MyThread(latch);
        MyThread thread3 = new MyThread(latch);
        MyThread thread4 = new MyThread(latch);
        thread1.setName("1");
        thread2.setName("2");
        thread3.setName("3");
        thread4.setName("4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        latch.countDown();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
//        System.out.println(sb.toString());
        System.out.println("contains ;;? -" + sb.toString().contains(";;"));
    }
}
