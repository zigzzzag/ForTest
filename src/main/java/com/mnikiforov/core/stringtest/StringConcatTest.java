package com.mnikiforov.core.stringtest;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zigzzzag on 06.09.16.
 */
public class StringConcatTest {

    private static final Set<String> TEST_SET;

    static {
        Set<String> testSet = new HashSet<>();
        for (int i = 0; i < 100_000; i++) {
            testSet.add(i + "");
        }
        TEST_SET = Collections.unmodifiableSet(testSet);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String concateStringBuilder = concatStringBuilder();
        System.out.println("concatStringBuilder total time: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        String concateStringBuffer = concatStringBuffer();
        System.out.println("concatStringBuffer total time:  " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        String concateSimple = concatSimple();
        System.out.println("concatSimple total time:        " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        String concate = concat();
        System.out.println("concat total time:              " + (System.currentTimeMillis() - start));
    }

    private static String concatSimple() {
        String result = "";
        for (String str : TEST_SET) {
            result += str;
        }
        return result;
    }

    private static String concat() {
        String result = "";
        for (String str : TEST_SET) {
            result = result.concat(str);
        }
        return result;
    }

    private static String concatStringBuilder() {
        StringBuilder result = new StringBuilder();
        for (String str : TEST_SET) {
            result.append(str);
        }
        return result.toString();
    }

    private static String concatStringBuffer() {
        StringBuffer result = new StringBuffer();
        for (String str : TEST_SET) {
            result.append(str);
        }
        return result.toString();
    }
}
