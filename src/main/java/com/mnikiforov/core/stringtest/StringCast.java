package com.mnikiforov.core.stringtest;

/**
 * Created by sbt-nikiforov-mo on 24.11.15.
 */
public class StringCast {

    public static void main(String[] args) {
        Object s = null;

        String s2 = (String) s;

        if (s2 == null) {
            System.out.println("s2 is null");
        } else {
            System.out.println(s2);
        }
    }
}
