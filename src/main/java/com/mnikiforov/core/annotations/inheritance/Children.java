package com.mnikiforov.core.annotations.inheritance;

/**
 * Created by zigzzzag on 11.08.16.
 */
public class Children extends Parent {

    @Override
    @SupportedType(type = "Children")
    public void importFile() {
        System.out.println("Children import file");
    }

    @Override
    public void exportFile() {
        System.out.println("Children export file");
    }
}
