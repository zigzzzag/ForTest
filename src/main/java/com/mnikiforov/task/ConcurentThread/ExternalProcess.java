package com.mnikiforov.task.ConcurentThread;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

import static com.mnikiforov.task.ConcurentThread.ExternalData.GROUP_ID_ARRAY;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by sbt-nikiforov-mo on 25.01.16.
 */
public enum ExternalProcess {

    INSTANCE;

    private static final AtomicLong ITER_COUNT = new AtomicLong(0);
    Map<Long, AtomicLong> mapIdGenerated = new HashMap<>();
    private Queue<Item> queue;

    private ExternalProcess() {
    }

    public void addRandomItem() {
        long groupId = GROUP_ID_ARRAY[new Random().nextInt(GROUP_ID_ARRAY.length)];
        if (!mapIdGenerated.containsKey(groupId)) {
            mapIdGenerated.put(groupId, new AtomicLong(0));
        }
        AtomicLong itemId = mapIdGenerated.get(groupId);

        Item randItem = new Item(itemId.getAndAdd(1), groupId);
        queue.add(randItem);
        System.out.println(ITER_COUNT.addAndGet(1) + ": add random item " + randItem);
    }

    public Queue<Item> getQueue() {
        return queue;
    }

    public void setQueue(Queue<Item> queue) {
        this.queue = queue;
    }
}
