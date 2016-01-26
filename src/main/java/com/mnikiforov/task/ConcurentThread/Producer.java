package com.mnikiforov.task.ConcurentThread;

import static com.mnikiforov.task.ConcurentThread.Consumer.GROUP_ID_ARRAY;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by sbt-nikiforov-mo on 25.01.16.
 */
public class Producer implements Runnable {

    private static final AtomicLong ITER_COUNT = new AtomicLong(0);
    Map<Long, AtomicLong> mapIdGenerated = new ConcurrentHashMap<>();
    private BlockingQueue<Item> queue;

    public Producer(BlockingQueue<Item> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < CTRunner.QUEUE_SIZE; i++) {
                addRandomItem();
            }
            for (int i = 0; i < 100; i++) {
                addRandomItem();
                Thread.sleep(50L);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void addRandomItem() throws InterruptedException {
        long groupId = GROUP_ID_ARRAY[new Random().nextInt(GROUP_ID_ARRAY.length)];
        if (!mapIdGenerated.containsKey(groupId)) {
            mapIdGenerated.put(groupId, new AtomicLong(0));
        }
        AtomicLong itemId = mapIdGenerated.get(groupId);

        Item randItem = new Item(itemId.getAndAdd(1), groupId);

        queue.put(randItem);

        System.err.println(ITER_COUNT.addAndGet(1) + ": " + Thread.currentThread().getName()
                + " add random item" + randItem);
    }

    public Queue<Item> getQueue() {
        return queue;
    }

    public void setQueue(BlockingQueue<Item> queue) {
        this.queue = queue;
    }
}
