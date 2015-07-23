package com.mnikiforov.advanced_java.collectiontest.maptest;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by SBT-Nikiforov-MO on 18.06.2015.
 */
public class SimpleLRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public SimpleLRUCache(int initialCapacity) {
        super(initialCapacity + 1, 1.1f, true);
        this.capacity = initialCapacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return this.size() > capacity;
    }
}
