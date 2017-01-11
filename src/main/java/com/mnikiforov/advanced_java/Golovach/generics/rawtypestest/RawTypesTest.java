package com.mnikiforov.advanced_java.Golovach.generics.rawtypestest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zigzzzag on 03.08.2015.
 */
public class RawTypesTest {
    List rawList = new ArrayList();
    List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        RawTypesTest raw = new RawTypesTest();
        raw.rawList = raw.list;
        raw.rawList.add(8);

//        String s =raw.rawList.get(0);
    }
}
