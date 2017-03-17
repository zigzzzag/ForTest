package com.mnikiforov.oop.inheritance.samefields;

import java.lang.reflect.Field;

public class Child extends Parent {

    private String name;

    public static void main(String[] args) throws IllegalAccessException {
        final Child child = new Child();

//        for () {
//        }

        for (Field f : child.getClass().getDeclaredFields()) {
            System.out.println(f.getName());
        }
    }
}
