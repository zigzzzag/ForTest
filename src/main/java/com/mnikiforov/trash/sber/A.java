package com.mnikiforov.trash.sber;

/**
 * Created by zigzzzag on 29.10.15.
 */
public class A {

    protected int i = 1;

    public A() {
        System.out.println("A() : i=" + i);
        setI();
    }

    public void setI() {
        i = 2;
        System.out.println("A.setI() : i=" + i);
    }

    public int getI() {

        System.out.println("A.getI() : i=" + i);
        return i;
    }
}
