package com.mnikiforov.core.utils;

import java.util.Random;

/**
 * Created by zigzzzag on 01.07.2015.
 */
public class RandomUtils {

    public static int randInt(int min, int max) {
        Random random = new Random();

        return random.nextInt((max - min) + 1) + min;
    }
}
