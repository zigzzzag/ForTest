package com.mnikiforov.advanced_java.Golovach.collectiontest.maptest;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by zigzzzag on 18.06.2015.
 */
public class WeakHashMapTest {

    public static void main(String[] args) {
        Map<Object, String> weakMap = new WeakHashMap<>();
        Map<Object, String> hashMap = new HashMap<>();

        Object forWeakMapObject = new Object();
        weakMap.put(forWeakMapObject, "gogi weak");
        Object forHashMapObject = new Object();
        hashMap.put(forHashMapObject, "gogi hash");

        forWeakMapObject = null;
        forHashMapObject = null;
        System.gc();

        mapTest(weakMap, "WeakMap");
        mapTest(hashMap, "HashMap");
    }

    private static void mapTest(Map<Object, String> map, String mapName) {
        for (int i = 0; i < 100_000; i++) {
            if (map.isEmpty()) {
                System.out.println(mapName + " is Empty! iterate: " + i);
                return;
            }
        }
        System.out.println(mapName + " is NOT Empty!");
    }
}
