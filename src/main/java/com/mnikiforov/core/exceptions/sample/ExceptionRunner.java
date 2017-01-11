package com.mnikiforov.core.exceptions.sample;

/**
 * Created by zigzzzag on 24.09.2015.
 */
public class ExceptionRunner {

    public static void main(String[] args) {
        try {
            f();
        } catch (SampleException ex) {
            System.err.println("SampleException message: " + ex.getMassage());
            ex.printStackTrace();
        }
    }

    private static void f() throws SampleException {
        throw new SampleException("SampleException from f()");
    }
}
