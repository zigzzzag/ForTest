package com.mnikiforov.core.finaltest;

public class B extends A {

    public static String staticMethodInAB() {
        return "B:staticMethodInAB";
    }

    // compile error
    //public static final String staticFinalMethod() {
    //    return "staticFinalMethod";
    //}

}
