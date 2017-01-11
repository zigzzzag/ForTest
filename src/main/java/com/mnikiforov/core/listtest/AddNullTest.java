package com.mnikiforov.core.listtest;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by zigzzzag on 02.06.2015.
 */
public class AddNullTest {

    public static void main(String[] args) {
        List<String> testList = new ArrayList<>();

        testList.add("aaa");
        testList.add(null);

        System.out.println(StringUtils.join(testList, ","));
        System.out.println();

        Set<String> testset = new HashSet<>();

        testset.add("    aaa    ");
        testset.add("   b       ");
        testset.add(null);

        Iterator<String> it = testset.iterator();
        while (it.hasNext()) {
            String val = it.next();
            if (val != null) {
                val = val.trim();
            }
        }

        System.out.println("testset: ");
        System.out.println(StringUtils.join(testset, ","));
    }
}
