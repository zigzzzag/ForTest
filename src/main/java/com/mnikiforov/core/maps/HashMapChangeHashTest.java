package com.mnikiforov.core.maps;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zigzzzag on 10/5/16.
 */
public class HashMapChangeHashTest {

    public static void main(String[] args) {
        HashMapChangeHashTest test = new HashMapChangeHashTest();
        test.test();
    }

    private void test() {
        Map<A, String> map = new HashMap<>();

        A a1 = new A().hash(1);
        A a2 = new A().hash(16);

        map.put(a1, "a1");
        map.put(a2, "a2");

        System.out.println(map.toString());

        System.out.println("a1: " + map.get(a1));
        a1.hash(2);
        System.out.println("a1: " + map.get(a1));
    }

    class A {
        int hash = 0;

        public A hash(int hash) {
            this.hash = hash;
            return this;
        }

        @Override
        public int hashCode() {
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            return true;
        }

        @Override
        public String toString() {
            return "A{" +
                    "hash=" + hash +
                    ",hashCode=" + hashCode() +
                    '}';
        }
    }
}
