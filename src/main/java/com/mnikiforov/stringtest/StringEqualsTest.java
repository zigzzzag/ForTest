package com.mnikiforov.stringtest;

/**
 * Created by sbt-nikiforov-mo on 15.10.15.
 */
public class StringEqualsTest {

    public static void main(String[] args) {
        String a = "aaa";
        String b = "aaa";
        System.out.println("a==b - " + (a==b));
        System.out.println("a.equals(b) - " + a.equals(b));
    }
}
