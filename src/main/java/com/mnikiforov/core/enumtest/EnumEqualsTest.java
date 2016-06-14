package com.mnikiforov.core.enumtest;

/**
 * Created by sbt-nikiforov-mo on 14.06.16.
 */
public class EnumEqualsTest {

    public enum Seasons {
        WINTER,
        SPRING,
        SUMMER,
        AUTUMN
    }

    public static void main(String[] args) {
        Object testObj = null;

        System.out.println(testObj == Seasons.WINTER);
        System.out.println(testObj.equals(Seasons.WINTER));// NPE
    }
}
