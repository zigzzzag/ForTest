package com.mnikiforov.annotations.inheritance;

/**
 * Created by sbt-nikiforov-mo on 11.08.16.
 */
public class Parent {

    @SupportedType(type = "Parent")
    public void importFile() {
        System.out.println("Parent import file");
    }

    public void exportFile() {
        System.out.println("Parent export file");
    }
}
