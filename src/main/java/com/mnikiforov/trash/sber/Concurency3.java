package com.mnikiforov.trash.sber;

/**
 * Created by sbt-nikiforov-mo on 29.10.15.
 */
public class Concurency3 {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("run : " + Thread.currentThread().getState());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        System.out.println("before start : " + t.getState());
        t.start();
        t.join();
        System.out.println("after join : " + t.getState());
    }
}
