package com.mnikiforov.advanced_java.Golovach.collectiontest.maptest;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by SBT-Nikiforov-MO on 18.06.2015.
 */
public class MapTest {

    public static void main(String[] args) {
        Map<Integer, String> testHashMap = new HashMap<>();
        MapTestUtils.fillMap(testHashMap);
        System.out.println("testHashMap: " + testHashMap);

        System.out.println("------------------------------------");

        Map<Integer, String> testLinkedHashMap = new LinkedHashMap<>();
        MapTestUtils.fillMap(testLinkedHashMap);
        System.out.println("testLinkedHashMap: " + testLinkedHashMap);

        System.out.println("------------------------------------");

        Map<Integer, String> testLinkedHashMapWithAccessOrder = new LinkedHashMap<>(5, 1, true);
        MapTestUtils.fillMap(testLinkedHashMapWithAccessOrder);
        testLinkedHashMapWithAccessOrder.get(3);
        testLinkedHashMapWithAccessOrder.get(5);
        testLinkedHashMapWithAccessOrder.get(1);
        System.out.println("testLinkedHashMapWithAccessOrder: " + testLinkedHashMapWithAccessOrder);

        System.out.println("------------------------------------");

        SimpleLRUCache<Integer, String> simpleLRUCache = new SimpleLRUCache<>(2);
        simpleLRUCache.put(1, "a");
        simpleLRUCache.put(2, "b");
        simpleLRUCache.put(3, "c");
        simpleLRUCache.get(2);
        simpleLRUCache.put(9, "yo");
        System.out.println("simpleLRUCache: " + simpleLRUCache);
    }

}
