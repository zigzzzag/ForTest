package com.mnikiforov.core.annotations.inheritance;

/**
 * Created by zigzzzag on 11.08.16.
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
