package com.mnikiforov.core.nestedClasses;

/**
 * Created by Zigzag on 18.10.2015.
 */
public class MemberInnerClasses {

    public void method() {
        System.out.println("MemberInnerClasses.method()");
    }

    public class InnerClass {
        public void method() {
            System.out.println("InnerClass.method()");
        }

        public void anotherMethod() {
            method();
        }

        public void anotherOuterMethod() {
            MemberInnerClasses.this.method();
        }
    }

    public void test() {
        System.out.println("----------mic.method();----------");
        method();
        System.out.println();

        System.out.println("----------MemberInnerClasses.this.method();----------");
        MemberInnerClasses.this.method();
        System.out.println();

        System.out.println("----------innerClass.method();----------");
        InnerClass innerClass = new InnerClass();
        innerClass.method();
        System.out.println();

        System.out.println("----------innerClass.anotherMethod();----------");
        innerClass.anotherMethod();
        System.out.println();

        System.out.println("----------innerClass.anotherOuterMethod();----------");
        innerClass.anotherOuterMethod();
        System.out.println();
    }

    public static void main(String[] args) {
        MemberInnerClasses mic = new MemberInnerClasses();
        mic.test();
    }
}
