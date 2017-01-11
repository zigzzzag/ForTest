package com.mnikiforov.core.polimorphismtest.thinkInJava;

/**
 * Created by zigzzzag on 29.02.16.
 */
public class Derived extends PrivateOverride {

    public void f() {
        System.out.println("public f()");
    }

    public void d() {
        System.out.println("public d()");
    }
}
