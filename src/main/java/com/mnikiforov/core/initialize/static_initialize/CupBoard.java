package com.mnikiforov.core.initialize.static_initialize;

/**
 * Created by sbt-nikiforov-mo on 16.02.16.
 */
public class CupBoard {

    Bowl bowl3 = new Bowl(3);
    static Bowl bowl4 = new Bowl(4);

    CupBoard() {
        System.err.println("CupBoard()");
        bowl4.f1(2);
    }

    void f3(int marker) {
        System.err.println("f3(" + marker + ")");
    }

    static Bowl bowl5 = new Bowl(5);
}
