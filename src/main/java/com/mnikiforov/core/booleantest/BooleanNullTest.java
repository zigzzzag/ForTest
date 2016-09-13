package com.mnikiforov.core.booleantest;

/**
 * Created by sbt-nikiforov-mo on 13.09.16.
 */
public class BooleanNullTest {

    public static void main(String[] args) {
        testIfNull();
        testCastNull();
    }

    private static void testCastNull() {
        Object o = null;
        Boolean b = (Boolean) o;
        System.out.println(b);
    }

    private static void testIfNull() {
        Boolean b = null;
        try {
            if (b) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        } catch (NullPointerException npe) {
            System.out.println("NPE");
        }
    }
}
