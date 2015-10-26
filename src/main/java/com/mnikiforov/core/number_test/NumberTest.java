package com.mnikiforov.core.number_test;

import org.apache.commons.lang.math.NumberUtils;

/**
 * Created by sbt-nikiforov-mo on 13.10.15.
 */
public class NumberTest {

    static String[] testArr = new String[]{"012", "01a2", "abc", "000"};

    public static void main(String[] args) {
        for (String str : testArr) {
            System.out.println(str + " is Digits " + NumberUtils.isDigits(str));
        }
        System.out.println("------------------------------------------------------------------------------------");
        for (String str : testArr) {
            System.out.println(str + " is Number " + NumberUtils.isNumber(str));
        }
    }
}
