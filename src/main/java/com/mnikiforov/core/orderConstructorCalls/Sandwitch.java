package com.mnikiforov.core.orderConstructorCalls;

/**
 * Created by zigzzzag on 20.10.2015.
 */
public class Sandwitch extends PortableLunch {

    private Bread bread = new Bread();
    private Cheese cheese = new Cheese();
    private Lettuce lettuce = new Lettuce();

    public Sandwitch() {
        System.out.println("Sandwitch();");
    }

    public static void main(String[] args) {
        new Sandwitch();
    }
}
