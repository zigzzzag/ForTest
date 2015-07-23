/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.settest;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mnikiforov
 */
public class SetTest {

    public static void main(String[] args) {
        setTest1();
    }

    private static void setTest1() {
        Set<Integer> testSet = new HashSet<Integer>();
        testSet.add(4);
        testSet.add(null);
        testSet.add(1);
        testSet.add(3);
        testSet.add(1);
        testSet.add(null);
        testSet.add(5);

        for (Integer i : testSet) {
            System.out.print(" " + i);
        }
        System.out.println("");
    }
}
