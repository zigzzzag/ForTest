package com.mnikiforov.core.polimorphismtest.thinkInJava;

/**
 * Created by sbt-nikiforov-mo on 29.02.16.
 */
public class PrivateOverride {

    private void f() {
        System.out.println("private f()");
    }

    protected void d() {
        System.out.println("private d()");
    }

    public static void main(String[] args) {
        PrivateOverride po = new Derived();
        po.f();
        po.d();

        System.out.println();

        Derived d = new Derived();
        d.f();
        d.d();
    }
}
