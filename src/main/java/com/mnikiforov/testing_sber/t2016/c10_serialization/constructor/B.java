package com.mnikiforov.testing_sber.t2016.c10_serialization.constructor;

import java.io.Serializable;

/**
 * Created by zigzzzag on 10/24/16.
 */
public class B extends A implements Serializable {

    public B() {
        System.out.println("B");
    }
}
