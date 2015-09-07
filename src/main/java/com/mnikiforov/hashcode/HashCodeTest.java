package com.mnikiforov.hashcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by SBT-Nikiforov-MO on 07.09.2015.
 */
public class HashCodeTest {
    private int hashCode = 0;

    @Override
    public int hashCode() {
        return hashCode++;
    }

    public static void main(String[] args) {
        Set<HashCodeTest> set = new HashSet<HashCodeTest>();

        HashCodeTest hashCodeTest = new HashCodeTest();
        set.add(hashCodeTest);
        System.out.println(set.size());
        for (Iterator<HashCodeTest> iter = set.iterator();
             iter.hasNext(); ) {
            iter.next();
            iter.remove();
        }
        System.out.println(set.size());
    }
}
