/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.listtest;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mnikiforov
 */
public class DoubleIterateOneListTest {

        private static List<String> testList = new ArrayList<>();

        public static void main(String[] args) {
                for (int i = 0; i < 100; i++) {
                        testList.add(String.valueOf(i));
                }

                int countElementInOneOterate = 10;

                for (int i = 0; i < testList.size() / countElementInOneOterate + 1; i++) {
                        System.out.println("iterate №" + i);
                        for (int j = i * countElementInOneOterate; j < Math.min((i + 1) * countElementInOneOterate, testList.size()); j++) {
                                System.out.println(testList.get(j));
                        }
                        System.out.println("-----------------------------");
                }
        }
}
