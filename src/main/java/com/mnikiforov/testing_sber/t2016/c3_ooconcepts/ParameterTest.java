package com.mnikiforov.testing_sber.t2016.c3_ooconcepts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zigzag on 16.10.2016.
 */
public class ParameterTest {

    public static void main(String[] args) {
        ParameterTest_B b = new ParameterTest_B();
        List l = new ArrayList();
        b.m(l);

        System.out.println(l.size());
    }
}
