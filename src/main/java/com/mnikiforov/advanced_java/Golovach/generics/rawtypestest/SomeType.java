package com.mnikiforov.advanced_java.Golovach.generics.rawtypestest;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by SBT-Nikiforov-MO on 03.08.2015.
 */
public class SomeType<T> {

    public static void main(String[] args) {
//        Стирание информации в runtime
//        Exception in thread "main" java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer
//        at com.mnikiforov.advanced_java.generics.rawtypestest.SomeType.test(SomeType.java:33)
//        at com.mnikiforov.advanced_java.generics.rawtypestest.SomeType.main(SomeType.java:21)
//        SomeType someType = new SomeType();

        SomeType<?> someType = new SomeType<>();
        List<String> list = Arrays.asList("value");
        someType.test(list);
    }

    public <E> void test(Collection<E> collection) {
        System.out.println("Method <E>test:");
        for (E e : collection) {
            System.out.println(e);
        }
    }

    public void test(List<Integer> integerList) {
        System.out.println("Method <List<Integer>>test:");
        for (Integer i : integerList) {
            System.out.println(i);
        }
    }
}
