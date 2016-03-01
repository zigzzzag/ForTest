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
        String formatStr = "%-12s: %-40s count: %-10d size: %-10d time: %6dms%n";

        long startTime = System.currentTimeMillis();
        CollectionUtils.fill(list, DEFAULT_SIZE);
        System.err.printf("fill %s size: %-10d initTime: %dms%n",
                list.getClass().getSimpleName(), list.size(), System.currentTimeMillis() - startTime);

        startTime = System.currentTimeMillis();
        CollectionUtils.insertInMiddle(list, INSERT_COUNT);
        System.err.printf(formatStr,
                list.getClass().getSimpleName(), "insert in middle", INSERT_COUNT, list.size(),
                System.currentTimeMillis() - startTime);

        startTime = System.currentTimeMillis();
        CollectionUtils.removeFromMiddle(list, INSERT_COUNT);
        System.err.printf(formatStr,
                list.getClass().getSimpleName(), "remove from middle", INSERT_COUNT, list.size(),
                System.currentTimeMillis() - startTime);

        startTime = System.currentTimeMillis();
        CollectionUtils.insertInMiddleWithIterator(list, INSERT_COUNT);
        System.err.printf(formatStr,
                list.getClass().getSimpleName(), "insert in middle with iterator", INSERT_COUNT, list.size(),
                System.currentTimeMillis() - startTime);

        startTime = System.currentTimeMillis();
        CollectionUtils.removeFromMiddleWithIterator(list, INSERT_COUNT);
        System.err.printf(formatStr,
                list.getClass().getSimpleName(), "remove from middle with iterator", INSERT_COUNT, list.size(),
                System.currentTimeMillis() - startTime);
    }
}
