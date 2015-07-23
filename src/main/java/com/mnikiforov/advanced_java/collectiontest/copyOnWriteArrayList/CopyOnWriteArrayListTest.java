package com.mnikiforov.advanced_java.collectiontest.copyOnWriteArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by SBT-Nikiforov-MO on 22.06.2015.
 */
public class CopyOnWriteArrayListTest {

    private static final Logger log = LoggerFactory.getLogger(CopyOnWriteArrayListTest.class);

    public static void main(String[] args) {
        List<Integer> synchronizedList = Collections.synchronizedList(new ArrayList<Integer>());
        List<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

        fillList(synchronizedList, 100);
        fillList(copyOnWriteArrayList, 100);

        checkList(synchronizedList, "synchronizedList");
        checkList(copyOnWriteArrayList, "copyOnWriteArrayList");
    }

    private static void fillList(List<Integer> list, int count) {
        for (int i = 0; i < count; i++) {
            list.add(i);
        }
    }

    private static void checkList(List<Integer> list, String listName) {
        CountDownLatch latch = new CountDownLatch(1);

        ExecutorService ex = Executors.newFixedThreadPool(2);
        Future<Long> f1 = ex.submit(new ListRunner(0, 50, list, latch));
        Future<Long> f2 = ex.submit(new ListRunner(50, 100, list, latch));

        latch.countDown();
        ex.shutdown();
        try {
            log.info("{} Thread 1: {}", listName, f1.get() / 1000);
            log.info("{} Thread 2: {}", listName, f2.get() / 1000);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        } catch (ExecutionException e) {
            log.error(e.getMessage(), e);
        }
    }
}

