package com.mnikiforov.core.initialize.static_initialize;

/**
 * Created by zigzzzag on 16.02.16.
 */
public class Table {
    static Bowl bowl1 = new Bowl(1);

    Table() {
        System.err.println("Table()");
        bowl2.f1(1);
    }

    void f2(int marker) {
        System.err.println("f2(" + marker + ")");
    }

    static Bowl bowl2 = new Bowl(2);
}
