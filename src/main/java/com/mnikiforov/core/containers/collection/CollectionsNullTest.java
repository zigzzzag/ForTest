package com.mnikiforov.core.containers.collection;

import java.util.List;

/**
 * Created by zigzzzag on 30.05.16.
 */
public class CollectionsNullTest {

    public static void main(String[] args) {
        List<String> nullList = null;
        for (String str : nullList) {
            System.out.println(str);
        }
    }
}
