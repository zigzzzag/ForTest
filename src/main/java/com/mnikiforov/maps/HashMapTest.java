package com.mnikiforov.maps;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SBT-Nikiforov-MO on 22.07.2015.
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", null);

        System.out.println(map.containsKey("1"));
    }
}
