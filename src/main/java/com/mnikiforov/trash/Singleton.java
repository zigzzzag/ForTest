package com.mnikiforov.trash;

/**
 * Created by sbt-nikiforov-mo on 26.10.15.
 */
public class Singleton {
    private static Singleton s = new Singleton();

    protected Singleton() {
        System.out.println("S");
    }

    public static Singleton getInstance() {
        return s;
    }
}
