package com.mnikiforov.task.ConcurentThread;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by sbt-nikiforov-mo on 25.01.16.
 */
public class Consumer implements Runnable {

    public static final long[] GROUP_ID_ARRAY = new long[]{1, 2};
    private Queue<Item> queue;
    private QueueHandler queueHandler;
    public static final AtomicLong COUNT_HANDLED_ITEMS = new AtomicLong(0);

    public Consumer(Queue<Item> queue, QueueHandler queueHandler) {
        this.queue = queue;
        this.queueHandler = queueHandler;
    }

    @Override
    public void run() {
        try {
            while (queueHandler.handleNextItem()) {
                COUNT_HANDLED_ITEMS.incrementAndGet();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Queue<Item> getQueue() {
        return queue;
    }
}
