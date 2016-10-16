package com.mnikiforov.testing_sber.t2016.c3_ooconcepts;

/**
 * Created by Zigzag on 16.10.2016.
 */
public class Polimorphism_A {

    protected int i = 1;

    public Polimorphism_A() {
        System.out.println("A");
        setI();
    }

    public void setI() {
        System.out.println("A.setI");
        i = 2;
    }

    public int getI() {
        return i;
    }
}
