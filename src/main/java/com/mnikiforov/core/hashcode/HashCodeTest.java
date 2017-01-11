package com.mnikiforov.core.hashcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by zigzzzag on 07.09.2015.
 */
public class HashCodeTest {
    private boolean a;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HashCodeTest)) return false;

        HashCodeTest that = (HashCodeTest) o;

        if (a != that.a) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (a ? 1 : 0);
    }

    public static void main(String[] args) {
        Set<HashCodeTest> set = new HashSet<HashCodeTest>();

        HashCodeTest hashCodeTest = new HashCodeTest();
        set.add(hashCodeTest);
        hashCodeTest.a = true;
        System.out.println(set.size());
        for (Iterator<HashCodeTest> iter = set.iterator();
             iter.hasNext(); ) {
            iter.next();
            iter.remove();
        }
        System.out.println(set.size());
    }
}
