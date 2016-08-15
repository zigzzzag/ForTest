package com.mnikiforov.core.multithreading.blocking_queue.impl_test;

import java.util.concurrent.BlockingQueue;

/**
 * Created by sbt-nikiforov-mo on 15.08.16.
 */
public class Producer implements Runnable {

    private final BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            try {
                queue.put(i);
                System.out.println(Thread.currentThread().getName() + " put " + i);
                i++;
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
