package com.mnikiforov.double_braces;

import com.mnikiforov.core.reflection.ClassInfoUtils;

/**
 * Created by sbt-nikiforov-mo on 15.06.16.
 */
public class DoubleBracesTest {

    {
        System.out.println("run instance initializer");
    }

    public DoubleBracesTest() {
        System.out.println("run DoubleBracesTest counstructor");
    }

    public static void main(String[] args) {
        new DoubleBracesTest() {{
            System.out.println("run anonymous instance initializer");
            ClassInfoUtils.showFullInfoClass(this.getClass());
        }};
    }
}
