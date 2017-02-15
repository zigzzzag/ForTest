package com.mnikiforov.algorithms;

import java.util.Arrays;

/**
 * Created by Zigzag on 11.02.2017.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] testArr1 = {11, 22, 33, 44, 55, 66, 77, 88, 99};
        for (int i = 0; i < 102; i++) {
            try {
                int idx = binarySearch(testArr1, i);
                System.out.println("i=" + i + "; idx=" + idx + "; value=" + testArr1[idx]);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

        Arrays.binarySearch(testArr1, 11);
//        binarySearch(testArr1, 3);
    }

    private static int binarySearch(final int[] arr, final int number) {
        if (number < arr[0] || number > arr[arr.length - 1]) {
            throw new IllegalArgumentException("invalid number " + number);
        }

        int l = -1;
        int r = arr.length;

        int m;
        while (r - l > 1) {
            m = (r + l) / 2;
            if (number <= arr[m]) {
                r = m;
            } else {
                l = m;
            }
        }

        if (r == arr.length) {
            r--;
        }

        if (arr[r] != number) {
            throw new IllegalArgumentException("invalid number " + number);
        }

        return r;
    }
}
