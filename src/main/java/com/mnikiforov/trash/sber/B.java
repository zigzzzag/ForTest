package com.mnikiforov.trash.sber;

/**
 * Created by zigzzzag on 29.10.15.
 */
public class B extends A {

    private int j = 3;

    @Override
    public void setI() {
        i = j;
        System.out.println("B.setI() : i=" + i);
    }

    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.getI());
    }
}
