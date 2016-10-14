package com.mnikiforov.testing_sber.t2016.system_library;

/**
 * Created by Zigzag on 15.10.2016.
 */
public class ClassTest {

    public static void main(String[] args) throws ClassNotFoundException {
//        can not create instance of class Class
//        Class<String> clazz = new Class<>();

        Class<String> clazz1 = (Class<String>) Class.forName("java.lang.String");
        Class<? extends String> clazz2 = new String().getClass();// Class<String> -- not compile - WTF!

        System.out.println(clazz1);
        System.out.println(clazz2);
    }
}
