package com.mnikiforov.testing_sber.t2016.c9_exceptions;

/**
 * Created by sbt-nikiforov-mo on 10/24/16.
 */
public class Runner {
    private void run() {
        try {
            run();
        } catch (Exception e) {
            System.out.println("exception,");
        } catch (Error e) {
            System.out.println("error");
        }
        System.out.println("finished");
    }

    public static void main(String[] args) {
        new Runner().run();
        System.out.println("done");
    }
}
