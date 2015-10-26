/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.core.randomUtils;

import java.util.Random;
import java.util.concurrent.SynchronousQueue;

/**
 * @author mnikiforov
 */
public class RandomUtils {

    public static long randLong(long min, long max) {
        Random rand = new Random();

        long randomNum = rand.nextInt((int) ((max - min) + 1)) + min;

        return randomNum;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println("randLong = " + randLong(5000L, 15000L));
        }
    }
}
