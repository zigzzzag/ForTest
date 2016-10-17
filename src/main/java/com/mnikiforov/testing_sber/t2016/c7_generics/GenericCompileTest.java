package com.mnikiforov.testing_sber.t2016.c7_generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zigzag on 18.10.2016.
 */
public class GenericCompileTest {

    public List<? extends TestObj> m4(List<? extends TestObj> tslList) {
        List<TestObj> list = new ArrayList<>();
        list.add(new TestObj());
        list.addAll(tslList);
        return list;
    }

    public void m5(List<? extends TestObj> tslList) {
        List<TestObj> list = new ArrayList<>();
        list.add(new TestObj());
        list.addAll(tslList);
    }

//    public List<TestObj> m3(List<? extends TestObj> tslList) {
//        List<? extends TestObj> list = new ArrayList<>();
//        list.addAll(tslList); //compile Error: java: incompatible types
//        return list;
//    }

//    public void m6(ArrayList<TestObj> tslList) {
//        List<? extends TestObj> list = new ArrayList<>();
//        list.add(new TestObj()); // compile error
//        list.addAll(tslList);
//    }
}
