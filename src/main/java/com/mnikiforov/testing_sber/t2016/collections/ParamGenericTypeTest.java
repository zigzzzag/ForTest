package com.mnikiforov.testing_sber.t2016.collections;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

/**
 * Created by Zigzag on 15.10.2016.
 */
public class ParamGenericTypeTest {

    private void size(List<?> l) {
        System.out.println(l.size());
    }

    private void test() {
        ParamGenericTypeTest p = new ParamGenericTypeTest();

//        List<?> list = new LinkedList<?>(); //not compile
        Vector<? extends Throwable> v = new Vector<Exception>();
        Set<String> s = new TreeSet<String>();
        List<?> l = new LinkedList<String>();

        p.size(v);
//        p.size(s);//not compile
        p.size(l);
    }

    public static void main(String[] args) {

    }
}
