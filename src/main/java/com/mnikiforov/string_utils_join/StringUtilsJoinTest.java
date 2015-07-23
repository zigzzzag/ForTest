package com.mnikiforov.string_utils_join;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by SBT-Nikiforov-MO on 09.06.2015.
 */
public class StringUtilsJoinTest {

    private static Set<Character> availableChars = new HashSet<Character>(Arrays.asList(
            new Character[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'}));

    private static String asString(Set<Character> invalidChars, String delimiter) {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for(Character ch : invalidChars) {
            if(first) {
                first = false;
            } else {
                result.append(delimiter);
            }

            result.append(ch);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(asString(availableChars, " "));
        System.out.println(StringUtils.join(availableChars, " "));
    }
}
