package com.mnikiforov.advanced_java.collectiontest.copyOnWriteArrayList;

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

    public static void main(String[] args) {
        List<Integer> list1 = Collections.synchronizedList(new ArrayList<Integer>());
        List<Integer> list2 = new CopyOnWriteArrayList<>();

        fillList(list1, 100);
        fillList(list2, 100);

        checkList(list1);
        checkList(list2);
    }

    private static void fillList(List<Integer> list, int count) {
        for (int i = 0; i < count; i++) {
            list.add(i);
        }
    }

    private static void checkList(List<Integer> list) {
        CountDownLatch latch = new CountDownLatch(1);

        ExecutorService ex = Executors.newFixedThreadPool(2);
        Future<Long> f1 = ex.submit(new ListRunner(0, 50, list, latch));
        Future<Long> f2 = ex.submit(new ListRunner(50, 100, list, latch));

        latch.countDown();
        try {
            System.out.println("Thread 1: " + f1.get());
            System.out.println("Thread 2: " + f2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

