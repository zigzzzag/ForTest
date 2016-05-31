package com.mnikiforov.core.operations.shift;

/**
 * Created by sbt-nikiforov-mo on 31.05.16.
 */
public class ShiftTest {

    public static void main(String[] args) {
        System.out.println(1 >> 2);
        int i = 1;
        System.out.println(1 << 2 + ++i);

        int k = 2;
        int m = 10;
        int s = 1 >> k++ + ++m - --k - m-- << 1;
        System.out.println("s = " + s);
        System.out.println("k = " + k);
        System.out.println("m = " + m);
    }
}
