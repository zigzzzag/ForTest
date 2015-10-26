/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.core.finallytest;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author mnikiforov
 */
public class FinallyTest {

    public static void main(String[] args) {
//        finallyTest();
//        finallyTest2();

        recursiveTestFinally(1);
    }

    private static void recursiveTestFinally(int functionNumber) {
        System.err.println("recursiveTestFinally " + functionNumber + " before Banana");
        try {
            System.err.println("recursiveTestFinally " + functionNumber + " into Banana");
            if (functionNumber < 2) {
                recursiveTestFinally(functionNumber + 1);
            }
        } finally {
            System.err.println("recursiveTestFinally " + functionNumber + " finally Banana");
        }
    }

    private static void finallyTest() {
        System.err.println("Hello before Banana");
        try {
            if (true) {
                System.err.println("Hello into Banana");
                throw new Exception();
//                return;
            }
            System.err.println("Hello after return Banana");
        } catch (Exception ex) {
            Logger.getLogger(FinallyTest.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            System.err.println("Hello finally Banana");
        }
    }

    private static void finallyTest2() {
        try {
            System.err.println("finnally1 start");
            try {
                System.err.println("finnally2 start");
                if (true) {
                    System.err.println("Hello into Banana");
                    throw new Exception();
//                return;
                }
            } catch (Exception ex) {
                Logger.getLogger(FinallyTest.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                System.err.println("finnally2 end");
            }
        } finally {
            System.err.println("finnally1 end");
        }
    }
}
