package com.mnikiforov.core.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sbt-nikiforov-mo on 03.08.16.
 */
public class GenericStringTest {

    public static void main(String[] args) {
        int a = newList();
//        int b = newList2();
    }

    private static <T extends List<Integer>> T newList() {
        return (T) new ArrayList<Integer>();
    }

    private static Object newList2() {
        return new ArrayList<Integer>();
    }
}
