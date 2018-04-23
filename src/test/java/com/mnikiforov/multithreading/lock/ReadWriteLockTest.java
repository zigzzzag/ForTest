package com.mnikiforov.multithreading.lock;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {

    private final ExecutorService executor = Executors.newFixedThreadPool(8);
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    @Test
    public void readWriteLockTest() {
        Map<String, String> map = new HashMap<>();

        executor.submit(() -> {
            readWriteLock.writeLock().lock();
            try {
                for (int i = 0; i < 3; i++) {
                    System.err.println(i + "-write(" + Thread.currentThread().getName() + "): sleep 1000");
                    sleep(1000);
                }
                map.put("foo", "bar");
            } finally {
                readWriteLock.writeLock().unlock();
            }
        });

        Runnable readTask = () -> {
            readWriteLock.readLock().lock();
            try {
                System.out.println(map.get("foo"));
                for (int i = 0; i < 3; i++) {
                    System.err.println(i + "-read(" + Thread.currentThread().getName() + "): sleep 1000");
                    sleep(1000);
                }
            } finally {
                readWriteLock.readLock().unlock();
            }
        };

        executor.submit(readTask);
        executor.submit(readTask);

        stop(executor);
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void stop(ExecutorService executor) {
        try {
            executor.shutdown();
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            System.err.println("termination interrupted");
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("killing non-finished tasks");
            }
            executor.shutdownNow();
        }
    }
}