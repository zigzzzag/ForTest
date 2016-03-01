package com.mnikiforov.core.containers.iterable;

/**
 * Created by sbt-nikiforov-mo on 01.03.16.
 */
public class IterableRun {

    public static void main(String... args) {
        CustomIterable<String> ci = new CustomIterable<>("q", "w", "e", "r", "t", "y", "u", "i", "o", "p");

        for (String str : ci) {
            System.out.println(str);
        }
    }
}
