package com.mnikiforov.core.containers.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sbt-nikiforov-mo on 11.05.16.
 */
public class ListLinkTest {

    private Integer int1;
    private Integer int2;
    private Integer int3;
    private Integer int4;
    private List<Integer> testList = Arrays.asList(int1, int2, int3, int4);
    private List<Integer> testList2 = new ArrayList<>();

    public ListLinkTest() {
        testList2.add(int1);

        int1 = new Integer(1);
        int2 = new Integer(2);
        int3 = new Integer(3);
        int4 = new Integer(4);

        testList2.add(int2);

        for (Integer integer : testList) {
            System.out.println(integer);
        }
        System.out.println("----------------------------------------------");
        for (Integer integer : testList2) {
            System.out.println(integer);
        }
    }

    public static void main(String[] args) {
        new ListLinkTest();
    }
}
