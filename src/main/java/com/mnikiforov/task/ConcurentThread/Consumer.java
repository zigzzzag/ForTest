package com.mnikiforov.task.ConcurentThread;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by zigzzzag on 25.01.16.
 */
public class Consumer implements Runnable {

    private Queue<Item> queue;
    private QueueHandler queueHandler;
    public static final AtomicLong COUNT_HANDLED_ITEMS = new AtomicLong(0);
    public static final AtomicLong LAST_OPERATIONS_TIME = new AtomicLong(0);

    public Consumer(Queue<Item> queue, QueueHandler queueHandler) {
        this.queue = queue;
        this.queueHandler = queueHandler;
    }

    @Override
    public void run() {
        try {
            while (true) {
                queueHandler.handleNextItem();
                if (COUNT_HANDLED_ITEMS.incrementAndGet() % 100 == 0) {
                    long deltaTime = System.currentTimeMillis() - LAST_OPERATIONS_TIME.getAndSet(System.currentTimeMillis());
                    System.err.println("HANDLED: " + COUNT_HANDLED_ITEMS.get() +
                            ", QUEUE_SIZE: " + queue.size() +
                            ", time: " + deltaTime);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Queue<Item> getQueue() {
        return queue;
    }
}
