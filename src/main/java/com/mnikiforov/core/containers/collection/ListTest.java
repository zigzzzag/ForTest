package com.mnikiforov.core.containers.collection;

import static com.mnikiforov.core.containers.collection.CollectionUtils.DEFAULT_SIZE;
import static com.mnikiforov.core.containers.collection.CollectionUtils.INSERT_COUNT;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sbt-nikiforov-mo on 29.02.16.
 */
public class ListTest {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        listTest(new LinkedList<Integer>());
        System.err.println();
        listTest(new ArrayList<Integer>());
    }

    private static void listTest(List<Integer> list) throws IllegalAccessException, InstantiationException {
        long startTime = System.currentTimeMillis();
        CollectionUtils.fill(list, DEFAULT_SIZE);
        System.err.println("fill " + list.getClass().getSimpleName() + " size: " + list.size()
                + ", initTime: " + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        CollectionUtils.insertInMiddle(list, INSERT_COUNT);
        System.err.println(list.getClass().getSimpleName() + " insert in middle; count: " + INSERT_COUNT
                + ", size: " + list.size()
                + ", time:" + (System.currentTimeMillis() - startTime) + "ms");
    }
}
