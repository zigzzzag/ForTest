package com.mnikiforov.core.containers.iterable;

/**
 * Created by zigzzzag on 01.03.16.
 */
public class IterableRun {

    public static void main(String... args) {
        CustomIterable<String> ci = new CustomIterable<>("q", "w", "e", "r", "t", "y", "u", "i", "o", "p");

        for (String str : ci) {
            System.out.print(str);
        }

        System.out.println();

        for (String str : ci.reversed()) {
            System.out.print(str);
        }
    }
}
