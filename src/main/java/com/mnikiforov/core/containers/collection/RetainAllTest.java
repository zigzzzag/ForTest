package com.mnikiforov.core.containers.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sbt-nikiforov-mo on 11.07.16.
 */
public class RetainAllTest {

    public static void main(String[] args) {
        List<String> testList1 = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
        List<String> testList2 = new ArrayList<>(Arrays.asList("3", "4", "5", "6"));

        System.out.println("retainAll: " + testList1.retainAll(testList2));
        System.out.println("testList1: " + testList1);
        System.out.println("testList2: " + testList2);
    }
}
