package com.mnikiforov.core.character;

/**
 * Created by sbt-nikiforov-mo on 10.06.16.
 */
public class CharTest {

    public static void main(String[] args/*можно String\u005b\u005d args*/) {
        char a1 = '[';
        char a2 = ']';
        System.out.println(a1 + " = " + getUnicodeString(a1));
        System.out.println(a2 + " = " + getUnicodeString(a2));
    }

    private static String getUnicodeString(char c) {
        return  "\\u" + Integer.toHexString(c | 0x10000).substring(1);
    }
}
