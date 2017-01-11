package com.mnikiforov.core.stringtest;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zigzzzag on 14.12.15.
 */
public class SplitAndTrimString {

    static String TEST_STRING = "aaa , ,, bbb ,";

    public static void main(String[] args) {
        Set<String> strs = splitAndTrim(TEST_STRING, ",");
        for (String str : strs) {
            System.out.println(str);
        }
    }

    private static Set<String> splitAndTrim(String value, String delimiter) {
        String[] parts = value.split(delimiter);
        Set<String> result = new HashSet<String>();

        for (String part : parts) {
            part = part.trim();

            if (!part.isEmpty()) {
                result.add(part);
            }
        }
        return result;
    }
}
