package com.mnikiforov.trash.sber;

import java.util.concurrent.locks.Lock;

/**
 * Created by zigzzzag on 29.10.15.
 */
public class Concurency1 {

    static StringBuilder sb = new StringBuilder();

    static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                synchronized (sb) {
                    sb.append(getName());
                    sb.append(";");
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread th1 = new MyThread();
        MyThread th2 = new MyThread();
        th1.setName("1");
        th2.setName("2");
        th1.start();
        th2.start();
        th1.join();
        th2.join();
        System.out.println(sb.toString());
    }
}
