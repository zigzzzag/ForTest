package com.mnikiforov.trash;

/**
 * Created by zigzzzag on 26.10.15.
 */
public class Base {

    public Object print() {
        return "Object from base method";
    }

    public static void main(String[] args) {
        Base test = new Child();
        System.out.println(test.print());
    }
}
