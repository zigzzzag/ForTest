package com.mnikiforov.core.linksToObject;

/**
 * Created by zigzzzag on 19.10.15.
 */
public class LinksToObject {

    static class TestClass {

        static final TestClass instance = new TestClass(1);

        static TestClass getInstance() {
            return instance;
        }

        int i;

        public TestClass(int i) {
            this.i = i;
        }
    }

    public static void main(String[] args) {
        TestClass testClass1 = TestClass.getInstance();
        TestClass testClass2 = TestClass.getInstance();
        System.out.println(testClass1 == testClass2);
    }
}
