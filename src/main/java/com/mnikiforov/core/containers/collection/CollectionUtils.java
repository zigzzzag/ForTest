package com.mnikiforov.core.containers.collection;

import java.util.List;
import java.util.ListIterator;

/**
 * Created by zigzzzag on 29.02.16.
 */
public class CollectionUtils {

    public static final int DEFAULT_SIZE = 1_000_000;
    public static final int INSERT_COUNT = 1_000;

    public static List<Integer> fill(List<Integer> list, int size) {
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        return list;
    }

    public static void removeFromMiddle(List<Integer> list, int count) {
        for (int i = 0; i < count; i++) {
            list.remove(list.size() / 2);
        }
    }

    public static void insertInMiddle(List<Integer> list, int count) {
        for (int i = 0; i < count; i++) {
            list.add(list.size() / 2, -i);
        }
    }

    public static void insertInMiddleWithIterator(List<Integer> list, int count) {
        ListIterator<Integer> it = list.listIterator();
        for (int i = 0; i < list.size() / 2; i++) {
            it.next();
        }

        for (int i = 0; i < count; i++) {
            it.add(-i);
        }
    }

    public static void removeFromMiddleWithIterator(List<Integer> list, int count) {
        ListIterator<Integer> it = list.listIterator();
        for (int i = 0; i < (list.size() - count) / 2; i++) {
            it.next();
        }

        for (int i = 0; i < count; i++) {
            it.next();
            it.remove();
        }
    }
}
