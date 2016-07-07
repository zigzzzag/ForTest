package com.mnikiforov.core.exceptions.lose_exception;

/**
 * Created by SBT-Nikiforov-MO on 25.09.2015.
 */
public class LoseExceptionRunner {

    public static void main(String[] args) throws SecondaryException {
        try {
            try {
                f();
            } finally {
//                try {
                g();
//                } catch (SecondaryException e) {
//                    e.printStackTrace();
//                }
            }
        } catch (VerymportantException e) {
            e.printStackTrace();
        }
    }

    private static void f() throws VerymportantException {
        throw new VerymportantException();
    }

    private static void g() throws SecondaryException {
        throw new SecondaryException();
    }
}
