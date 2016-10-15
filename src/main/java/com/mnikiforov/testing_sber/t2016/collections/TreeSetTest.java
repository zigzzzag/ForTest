package com.mnikiforov.testing_sber.t2016.collections;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by Zigzag on 15.10.2016.
 */
public class TreeSetTest {

    public static void main(String[] args) {
        TreeSetTest tst = new TreeSetTest();
        tst.testNullElement();
        tst.testNotComparable();
    }

    private void testNullElement() {
        TreeSet<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        set.add(null);
        System.out.println(set);
    }

    private void testNotComparable() {
        TreeSet<NotComarableClass> set = new TreeSet<>();
        try {
            set.add(new NotComarableClass());
        } catch (ClassCastException ex) {
            System.out.println("ClassCastException in testNotComparable");
            return;
        }
        System.out.println(set);
    }

    class NotComarableClass {
    }
}
