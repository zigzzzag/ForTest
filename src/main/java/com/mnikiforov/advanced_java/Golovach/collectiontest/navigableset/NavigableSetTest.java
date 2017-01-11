package com.mnikiforov.advanced_java.Golovach.collectiontest.navigableset;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by zigzzzag on 16.06.2015.
 */
public class NavigableSetTest {
    private static final Logger log = LoggerFactory.getLogger(NavigableSetTest.class);

    public static void main(String[] args) {
        NavigableSet<Integer> testSet = new TreeSet<>();
        for (int i = 0; i < 100; i++) {
            testSet.add(i);
        }

        log.info("testSet.lower(15) = {}", testSet.lower(15));
        log.info("testSet.lower(-3) = {}", testSet.lower(-3));
        log.info("testSet.lower(1553) = {}", testSet.lower(1553));
//        try {
//            log.info("testSet.lower(null) = {}", testSet.lower(null));
//        } catch (NullPointerException ex) {
//            log.error(ex.getMessage(), ex);
//        }

        log.info("-------------------------------------------");
        log.info("testSet.higher(15) = {}", testSet.higher(15));
        log.info("testSet.higher(-3) = {}", testSet.higher(-3));
        log.info("testSet.higher(1553) = {}", testSet.higher(1553));
//        try {
//            log.info("testSet.higher(null) = {}", testSet.higher(null));
//        } catch (NullPointerException ex) {
//            log.error(ex.getMessage(), ex);
//        }

        log.info("-------------------------------------------");
        SortedSet<Integer> headSet = testSet.headSet(14);
        log.info("testSet.headSet(14):        {}", StringUtils.join(headSet, ", "));

        log.info("-------------------------------------------");
        SortedSet<Integer> headSet2 = testSet.headSet(14, true);
        log.info("testSet.headSet(14, true):  {}", StringUtils.join(headSet2, ", "));

        log.info("-------------------------------------------");
        SortedSet<Integer> tailSet = testSet.tailSet(84);
        log.info("testSet.tailSet(84):        {}", StringUtils.join(tailSet, ", "));

        log.info("-------------------------------------------");
        SortedSet<Integer> tailSet2 = testSet.tailSet(84, false);
        log.info("testSet.tailSet(84, false): {}", StringUtils.join(tailSet2, ", "));
    }
}
