package com.mnikiforov.core.polimorphismtest.thinkInJava;

/**
 * Created by sbt-nikiforov-mo on 29.02.16.
 */
public class Derived extends PrivateOverride {

    public void f() {
        System.out.println("public f()");
    }

    public void d() {
        System.out.println("public d()");
    }
}
