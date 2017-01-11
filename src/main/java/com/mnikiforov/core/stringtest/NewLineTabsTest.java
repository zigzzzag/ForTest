package com.mnikiforov.core.stringtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zigzzzag on 24.03.2015.
 */
public class NewLineTabsTest {

    private static final Logger log = LoggerFactory.getLogger(NewLineTabsTest.class);
    private static List<String> testStringList = Arrays.asList("   1111   1111    111\t111111", "11111\n" +
            "2222", "\t1111\t22\n\n\n2\n" +
            "\t1212\t");

    public static void main(String[] args) {
        for (String str : testStringList) {
            str = str.trim().replace("\n", "").replace("\r", "").replace("\t", "").replaceAll(" +", " ");
            log.info("{} isValid - {}", str, isValid(str));
        }
    }

    private static boolean isValid(String str) {
        return !str.contains("\n") && !str.contains("\r") && !str.contains("\t") && !str.contains("  ");
    }
}
