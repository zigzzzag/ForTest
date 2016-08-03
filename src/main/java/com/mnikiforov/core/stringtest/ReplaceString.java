package com.mnikiforov.core.stringtest;

/**
 * Created by sbt-nikiforov-mo on 03.08.16.
 */
public class ReplaceString {

    public static void main(String[] args) {
        System.out.println(onlyDigits("aw12d34"));
    }

    public static String onlyDigits(String str) {
        return str.replaceAll("\\D", "");
    }
}
