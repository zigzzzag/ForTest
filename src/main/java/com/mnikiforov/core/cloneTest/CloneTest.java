/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.core.cloneTest;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mnikiforov
 */
public class CloneTest {

        public static void main(String[] args) {
                CloneTest cloneTest = new CloneTest();
                cloneTest.test1();
        }

        private void test1() {// хрень
                Map<String, String> testMap1 = new HashMap<>();
                testMap1.put("1", "2");

                Map<String, String> testMap2 = new HashMap<>(testMap1);

                for (Map.Entry<String, String> entry : testMap1.entrySet()) {
                        System.out.println("key " + entry.getKey() + " value " + entry.getValue());
                }
                for (Map.Entry<String, String> entry : testMap2.entrySet()) {
                        System.out.println("key " + entry.getKey() + " value " + entry.getValue());
                }
        }
}
