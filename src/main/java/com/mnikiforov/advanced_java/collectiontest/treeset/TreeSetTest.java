package com.mnikiforov.advanced_java.collectiontest.treeset;

import org.apache.commons.lang.StringUtils;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by SBT-Nikiforov-MO on 15.06.2015.
 */
public class TreeSetTest {
    public static void main(String[] args) {
        Set<Long> testSet = new TreeSet<>();
        testSet.add(12L);
        testSet.add(122L);
        testSet.add(2L);

        System.out.println(StringUtils.join(testSet, ", "));
    }
}
