package com.mnikiforov.trash.sber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by sbt-nikiforov-mo on 29.10.15.
 */
public class BinarySearch {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(new Integer[]{7, -3, 15, 2, -19}));
        int x = 2;
        int y = Collections.binarySearch(list, x);
        System.out.println(y);//неопределено, т.к. список неотсортирован
    }
}
