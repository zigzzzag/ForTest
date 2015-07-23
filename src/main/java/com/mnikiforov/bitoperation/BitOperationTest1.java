/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.bitoperation;

/**
 *
 * @author mnikiforov
 */
public class BitOperationTest1 {

    public static void main(String[] args) {
	long dx = 32768 / 64;
	long x = 32768 - dx;

	System.out.println(inCube(x));
	System.out.println(inCubeInButs(x));
    }

    private static long inCube(long x) {
	return x * x * x;
    }

    private static long inCubeInButs(long x) {
	return (((x * x) >> 15) * x) >> 15;
    }
}
