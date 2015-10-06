package com.mnikiforov.string_builder;

/**
 * Created by sbt-nikiforov-mo on 06.10.15.
 */
public class StringBuilderTest {

    public static void main(String[] args) {
        Object nullObject = null;
        StringBuilder sb = new StringBuilder();
        sb.append("aaa");
        sb.append(nullObject);
        System.out.println(sb.toString());
    }
}
