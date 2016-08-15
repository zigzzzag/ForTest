package com.mnikiforov.core.enum_map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sbt-nikiforov-mo on 15.08.16.
 */
public class EnumMapContainsTest {

    public static void main(String[] args) {
        EnumSet<EnumTest> enumSet = EnumSet.range(EnumTest.A5, EnumTest.A995);
        List<EnumTest> arrayList = new ArrayList<>(enumSet);
        Set<EnumTest> hashSet = new HashSet<>(enumSet);

        System.out.println("array:   " + containsTestTime(arrayList) / 1_000_000 + "ms");
        System.out.println("hashset: " + containsTestTime(hashSet) / 1_000_000 + "ms");
        System.out.println("enumset: " + containsTestTime(enumSet) / 1_000_000 + "ms");

        System.out.println();

        System.out.println("array:   " + containsTestTime(arrayList) / 1_000_000 + "ms");
        System.out.println("hashset: " + containsTestTime(hashSet) / 1_000_000 + "ms");
        System.out.println("enumset: " + containsTestTime(enumSet) / 1_000_000 + "ms");

        System.out.println();

        System.out.println("array:   " + containsTestTime(arrayList) / 1_000_000 + "ms");
        System.out.println("hashset: " + containsTestTime(hashSet) / 1_000_000 + "ms");
        System.out.println("enumset: " + containsTestTime(enumSet) / 1_000_000 + "ms");
    }

    private static <E> long containsTestTime(Collection<E> col) {
        long fullNanoTime = 0;

        for (int i = 0; i < 100; i++) {
            for (EnumTest et : EnumTest.values()) {
                long start = System.nanoTime();
                col.contains(et);
                fullNanoTime += System.nanoTime() - start;
            }
        }

        return fullNanoTime;
    }
}
