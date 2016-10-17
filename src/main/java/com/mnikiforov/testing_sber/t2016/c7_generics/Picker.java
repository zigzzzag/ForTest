package com.mnikiforov.testing_sber.t2016.c7_generics;

/**
 * Created by Zigzag on 18.10.2016.
 */
public class Picker<K> {

    public K pick(K k1, K k2) {
        return k1.hashCode() > k2.hashCode() ? k1 : k2;
    }

    public static void main(String[] args) {
        Picker<Integer> p = new Picker<>();
        System.out.println(p.pick(1, 2).intValue() + 1);
    }
}
