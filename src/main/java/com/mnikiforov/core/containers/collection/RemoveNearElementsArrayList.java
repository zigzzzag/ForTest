package com.mnikiforov.core.containers.collection;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zigzag on 05.06.2016.
 */
public class RemoveNearElementsArrayList {
    private static boolean print = false;
    private static int NEAR_COUNT = 100_000;

    public static void main(String[] args) {
        List<Object> list1 = new ArrayList<Object>();
        List<Object> list2 = new ArrayList<Object>();
        for (int i = 0; i < 1_000_000; i++) {
            Integer el = new Integer(i);
            list1.add(el);
            list2.add(el);
        }

        if (print) {
            System.out.println("before:");
            System.out.println(StringUtils.join(list1, ","));
            System.out.println(StringUtils.join(list2, ","));
        }

        long start = System.currentTimeMillis();
        simpleRemoveByIdx(list1, list1.size() / 2, NEAR_COUNT);
        System.out.println("simple: " + (System.currentTimeMillis() - start) + "ms");
        start = System.currentTimeMillis();
        advancedRemoveByIdx(list2, list2.size() / 2, NEAR_COUNT);
        System.out.println("advanced: " + (System.currentTimeMillis() - start) + "ms");

        if (print) {
            System.out.println("after:");
            System.out.println(StringUtils.join(list1, ","));
            System.out.println(StringUtils.join(list2, ","));
        }

        System.out.println(list1.equals(list2));
    }

    private static void simpleRemoveByIdx(List<Object> list, int idx, int countNearElements) {
        for (int i = idx - countNearElements; i <= idx + countNearElements; i++) {
            list.remove(idx - countNearElements);
        }
    }

    private static void advancedRemoveByIdx(List<Object> list, int idx, int countNearElements) {
        for (int i = idx + countNearElements; i < list.size() - 1; i++) {
            list.set(i - 2 * countNearElements, list.get(i + 1));
        }
        for (int i = 0; i < 1 + 2 * countNearElements; i++) {
            list.remove(list.size() - 1);
        }
    }
}
