package com.mnikiforov.core.maps;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sbt-nikiforov-mo on 23.11.15.
 */
public class MapNullKeyTest {

    public static void main(String[] args) {
        Map<String, String> testMap = new HashMap<>();

        testMap.put(null, null);

        for (Map.Entry<String, String> entry : testMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
