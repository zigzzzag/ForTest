package com.mnikiforov.testing_sber.t2016.other.annotation;

/**
 * Created by zigzzzag on 10/19/16.
 */
@MyAnnotation
public class AnnotationTest {

    @MyAnnotation
    private String name;

    @MyAnnotation
    public void getFullName() {
    }
}
