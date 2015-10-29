package com.mnikiforov.trash.sber;

/**
 * Created by sbt-nikiforov-mo on 29.10.15.
 */
public class Concurency2 {

    static volatile/**/ boolean running = true;

    static class MyThread extends Thread {
        @Override
        public void run() {
            while (running) {
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        thread.start();
        Thread.sleep(1000);
        running = false;
    }
}
