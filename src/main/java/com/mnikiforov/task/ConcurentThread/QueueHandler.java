package com.mnikiforov.task.ConcurentThread;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sbt-nikiforov-mo on 26.01.16.
 */
public class QueueHandler {

    private BlockingQueue<Item> queue;
    private Map<Long, Lock> lockMap = new ConcurrentHashMap<>();

    public QueueHandler(BlockingQueue<Item> queue) {
        this.queue = queue;
    }

    public void handleNextItem() throws InterruptedException {
        Item item = queue.take();

//        if (item == null) {
//            System.err.println(Thread.currentThread().getName() + ": queue is empty!!!");
//            return;
//        }

        lockByGroupId(item.getGroupId());
        try {
            doSomething(item);
        } finally {
            unlockByGroupId(item.getGroupId());
        }
    }

    private void doSomething(Item item) {
        long startTime = System.currentTimeMillis();
        try {
            Thread.sleep(10L + new Random().nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long finishTime = System.currentTimeMillis();
        if (CTRunner.SHOW_TRACE) {
            System.err.println(Thread.currentThread().getName() + ": processed item" + item +
                    "[" + parseMillis(startTime) + "," + parseMillis(finishTime) + "]");
        }
    }

    protected String parseMillis(long timeInMillis) {
        long millis = timeInMillis % 1000;
        long sec = (timeInMillis / 1000) % 60;
        long minute = (timeInMillis / 60_000) % 60;
        return minute + ":" + sec + "." + millis % 1000;
    }

    private void lockByGroupId(long groupId) {
        Lock groupLock = lockMap.get(groupId);

        if (groupLock == null) {
            groupLock = new ReentrantLock(true);
            lockMap.put(groupId, groupLock);
        }

        groupLock.lock();
    }

    private void unlockByGroupId(long groupId) {
        Lock groupLock = lockMap.get(groupId);

        if (groupLock == null) {
            throw new RuntimeException("groupLock is null, groupId=" + groupId);
        }

        groupLock.unlock();
    }
}
