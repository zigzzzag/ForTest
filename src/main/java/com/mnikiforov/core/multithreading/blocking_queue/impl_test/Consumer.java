package com.mnikiforov.core.multithreading.blocking_queue.impl_test;

import java.util.concurrent.BlockingQueue;

/**
 * Created by zigzzzag on 15.08.16.
 */
public class Consumer implements Runnable {

    private final BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer takeElement = queue.take();
                System.out.println(Thread.currentThread().getName() + " take " + takeElement);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
