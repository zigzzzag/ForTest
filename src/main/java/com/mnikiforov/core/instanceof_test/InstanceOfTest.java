package com.mnikiforov.core.instanceof_test;

/**
 * Created by sbt-nikiforov-mo on 16.05.16.
 */
public class InstanceOfTest {

    public static void main(String[] args) {
        String str = "String test";
        String strNull = null;

        if (str instanceof String) {
            System.out.println(str + " - it's ok!");
        }

        if (strNull instanceof String) {
            System.out.println(strNull + " - it's ok!");
        }
    }
}
