package com.mnikiforov.advanced_java.collectiontest.copyOnWriteArrayList;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * Created by SBT-Nikiforov-MO on 22.06.2015.
 */
public class ListRunner implements Callable<Long> {

    private int start;
    private int end;
    private List<Integer> list;
    private CountDownLatch latch;

    public ListRunner(int start, int end, List<Integer> list, CountDownLatch latch) {
        this.start = start;
        this.end = end;
        this.list = list;
        this.latch = latch;
    }

    @Override
    public Long call() throws Exception {
        latch.await();

        long startTime = System.nanoTime();
        for (int i = start; i < end; i++) {
            list.get(i);
//          copyOnWriteArrayList с редкими вставками оч шустрый, но если вставок много то ваще тормоз!!!
            if (i % 2 == 0) {
                list.add(i * 10);
            }
        }

        return System.nanoTime() - startTime;
    }
}
