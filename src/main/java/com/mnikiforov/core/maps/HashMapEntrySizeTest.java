package com.mnikiforov.core.maps;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zigzzzag on 22.07.2015.
 */
public class HashMapEntrySizeTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Map<String, String> map = new HashMap<>();
        fillMap(map);

        soutAllHashMapFields();

        soutHashMapNestedClasses();

        soutTableHashMapInfo(map);
    }

    private static void soutAllHashMapFields() {
        System.out.println("All fields of HashMap:");
        for (Field f : HashMap.class.getDeclaredFields()) {
            System.out.println(f.getName());
        }
        System.out.println("----------------------------------------------------------");
        System.out.println();
    }

    private static void fillMap(Map<String, String> map) {
        //method HashMap.indexFor(int h, int length) give similar result for h = "idx" and "0"
        map.put("idx", "Hello");
        for (int i = 0; i < 32; i++) {
            map.put(String.valueOf(i), "Hello" + i);
        }
    }

    private static void soutTableHashMapInfo(Map<?, ?> map) throws NoSuchFieldException, IllegalAccessException {
        Field thresholdField = HashMap.class.getDeclaredField("threshold");
        thresholdField.setAccessible(true);

        Field tableField = HashMap.class.getDeclaredField("table");
        tableField.setAccessible(true);

        Map.Entry<?, ?>[] tableMap = (Map.Entry<?, ?>[]) tableField.get(map);
        System.out.println("threshold = " + thresholdField.get(map) + ", " + "tableMap.length = " + tableMap.length + ", map.size() = " + map.size());
        for (int i = 0; i < tableMap.length; i++) {
            Map.Entry<?, ?> entry = tableMap[i];
            if (entry != null) {
                soutEntry(entry, i);
            }
        }
    }

    private static void soutEntry(Map.Entry<?, ?> entry, int i) throws NoSuchFieldException, IllegalAccessException {
        System.out.println("index: " + i + ", " + "key=" + entry.getKey() + ", value=" + entry.getValue());
        Field nextFieldEntry = entry.getClass().getDeclaredField("next");
        nextFieldEntry.setAccessible(true);
        Map.Entry<?, ?> nextEntry = (Map.Entry<?, ?>) nextFieldEntry.get(entry);
        if (nextEntry != null) {
            soutEntry(nextEntry, i);
        }
    }

    private static Class getHashMapEntryClass() {
        for (Class<?> clazz : HashMap.class.getDeclaredClasses()) {
            if ("Entry".equals(clazz.getSimpleName())) {
                return clazz;
            }
        }
        return null;
    }

    private static void soutHashMapNestedClasses() {
        System.out.println("HashMap have nested Classes:");
        for (Class<?> clazz : HashMap.class.getDeclaredClasses()) {
            System.out.println(clazz.getName());
        }
        System.out.println("----------------------------------------------------------");
        System.out.println();
    }
}
