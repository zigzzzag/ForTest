package com.mnikiforov.testing_sber.t2016.c7_generics;

/**
 * Created by Zigzag on 18.10.2016.
 */
public class WildCard {


    interface BI {
    }

    interface DI extends BI {
    }

    interface DDI extends DI {
    }

    static class C<T> {
    }

    static void foo(C<? super DI> arg) {
    }

    public static void main(String[] args) {
        foo(new C<BI>());
        foo(new C<DI>());
//        foo(new C<DDI>()); // compile error
        foo(new C());
    }
}
