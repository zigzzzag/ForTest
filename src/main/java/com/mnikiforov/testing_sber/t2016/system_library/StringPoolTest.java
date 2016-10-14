package com.mnikiforov.testing_sber.t2016.system_library;

/**
 * Created by Zigzag on 15.10.2016.
 */
public class StringPoolTest {

    public static void main(String[] args) {
        String s1 = new String("hello");
        String s2 = new String("hello");
        String s3 = "hello";
        String s4 = "hello";

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s3 == s4);
    }
}
