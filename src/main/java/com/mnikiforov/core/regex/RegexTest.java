/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.core.regex;

/**
 *
 * @author mnikiforov
 */
public class RegexTest {

    private static String str;
    public static final String HISTORY_CALL = "Вызывался оператором ${} в ${}";

    public static void main(String[] args) {
	str = HISTORY_CALL.replaceFirst("\\$\\{\\}", "12345");
	System.out.println(str);
    }
}
