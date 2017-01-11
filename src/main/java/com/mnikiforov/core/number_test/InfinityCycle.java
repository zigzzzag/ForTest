package com.mnikiforov.core.number_test;

/**
 * Created by zigzzzag on 07.06.16.
 */
public class InfinityCycle {

    public static void main(String[] args) {
        double i = 0d;
        while (i != 10) {
            System.out.println(i);
            i += 0.1;

            //break
            if (i > 50) {
                break;
            }
        }
        System.out.println("finished!");
    }
}
