package com.mnikiforov.core.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sbt-nikiforov-mo on 14.06.16.
 */
public class GenericsTest {

    public static void main(String[] args) {
        List emptyGenericList = new ArrayList();
        List<Object> objectGenericList = new ArrayList();
        List<String> stringGenericList = new ArrayList();

        GenericsTest test = new GenericsTest();

        test.emptyGeneric(emptyGenericList);
        test.emptyGeneric(objectGenericList);
        test.emptyGeneric(stringGenericList);

        test.objectGeneric(emptyGenericList);
        test.objectGeneric(objectGenericList);
//        test.objectGeneric(stringGenericList);
//        java: method objectGeneric in class com.mnikiforov.core.generics.GenericsTest cannot be applied to given types;
//        reason: actual argument java.util.List<java.lang.String> cannot be converted to java.util.List<java.lang.Object> by method invocation conversion

        test.stringGeneric(emptyGenericList);
//        test.stringGeneric(objectGenericList);
//        java: method stringGeneric in class com.mnikiforov.core.generics.GenericsTest cannot be applied to given types;
//        reason: actual argument java.util.List<java.lang.Object> cannot be converted to java.util.List<java.lang.String> by method invocation conversion
        test.stringGeneric(stringGenericList);
    }

    private void emptyGeneric(List list) {
        System.out.println("emptyGeneric()");
    }

    private void objectGeneric(List<Object> list) {
        System.out.println("objectGeneric()");
    }

    private void stringGeneric(List<String> list) {
        System.out.println("stringGeneric()");
    }
}
