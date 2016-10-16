package com.mnikiforov.testing_sber.t2016.c3_ooconcepts;

/**
 * Created by Zigzag on 16.10.2016.
 */
public class Polimorphism_B extends Polimorphism_A {

    private int j = 3;
    private Polimorphism_C c = new Polimorphism_C();

    @Override
    public void setI() {
        System.out.println("B.setI (j==" + j + ")");
        i = j;
    }

    public Polimorphism_B() {
        System.out.println("B (j==" + j + ")");
    }

    public static void main(String[] args) {
        Polimorphism_B b = new Polimorphism_B();
        System.out.println(b.getI());
    }
}
