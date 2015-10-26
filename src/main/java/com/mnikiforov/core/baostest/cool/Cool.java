/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.core.baostest.cool;

/**
 * @author mnikiforov
 */
public class Cool {

    public static void main(String[] args) {
        powerOfTwoTest();

        System.out.println(Integer.toBinaryString(8));
        System.out.println(Integer.toBinaryString(-8));
    }

    private static void powerOfTwoTest() {
        int n = 2;
        System.out.println("powerOfTwo(2) " + powerOfTwo(n));

        n = 256;
        System.out.println("powerOfTwo(256) " + powerOfTwo(n));

        n = 255;
        System.out.println("powerOfTwo(255) " + powerOfTwo(n));
    }

    private static boolean powerOfTwo(int n) {
        return (n & -n) == n;
    }
}
