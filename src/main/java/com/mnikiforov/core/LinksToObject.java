package com.mnikiforov.core;

/**
 * Created by Zigzag on 18.10.2015.
 */
public class LinksToObject {

    public static void main(String[] args) {
        String strBefore = "strBefore";

        String strAfter = method1(strBefore);
        System.out.println("strBefore: " + strBefore);
        System.out.println("strAfter: " + strAfter);

        method2(strBefore);
        System.out.println("strAfter method2: " + strBefore);
    }

    private static String method1(String str) {
        return str += "1";
    }

    private static void method2(String str) {
        str += "1";
    }
}
