package com.mnikiforov.core.nestedClasses;

/**
 * Created by Zigzag on 19.06.2016.
 */
public class GetClassFromStaticMethod {

    public static void main(String[] args) {
        System.out.println(new Object(){}.getClass().getEnclosingClass());
    }
}
