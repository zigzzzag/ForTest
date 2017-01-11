package com.mnikiforov.core.constructor;

/**
 * Created by zigzzzag on 14.06.16.
 */
public class ConstructorTest {

    public static ConstructorTest instance = new ConstructorTest();
    private static final int DELTA = 5;
    private static int BASE = 7;
    private int x;

    public ConstructorTest() {
        x = BASE + DELTA;
    }

    public static int getBASE() {
        return BASE;
    }

    public static void main(String[] args) {
        System.out.println(ConstructorTest.instance.x);
        System.out.println(new ConstructorTest().x);
    }
}
