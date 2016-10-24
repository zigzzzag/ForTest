package com.mnikiforov.testing_sber.t2016.c10_serialization;

import java.io.Serializable;

/**
 * Created by sbt-nikiforov-mo on 10/24/16.
 */
public class A implements Serializable {

    transient int a = 7;
    static int b = 9;
}
