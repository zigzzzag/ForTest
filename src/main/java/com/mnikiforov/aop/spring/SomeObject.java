package com.mnikiforov.aop.spring;

/**
 * Created by zigzzzag on 1/10/17.
 */
public class SomeObject {

    public void longLoop() {
        try {
            int delay = (int) (Math.random() * 10);
            System.out.println("Delay time : " + delay);
            Thread.sleep(delay * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printInteger(int n) {
        System.out.println("method printInteger, n = " + n);
    }
}
