/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.core.longTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mnikiforov
 */
public class LongTestNull {

    public static void main(String[] args) {
        Map<String, Long> map = new HashMap<String, Long>();
        map.put("1", 1L);
        long testLong1 = map.get("1");
        long testLong2 = map.get("2");
        System.out.println("testLong1 = " + testLong1 + "; testLong2 = " + testLong2);
    }
}
