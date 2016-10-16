package com.mnikiforov.testing_sber.t2016.c2_collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Zigzag on 15.10.2016.
 */
public class BinarySearchTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(new Integer[]{7, -3, 15, 2, -19}));
        int x = 2;
        int y = Collections.binarySearch(list, x);
        System.out.println(y);
    }
}
