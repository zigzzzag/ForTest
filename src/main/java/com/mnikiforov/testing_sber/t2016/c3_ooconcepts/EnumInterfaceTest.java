package com.mnikiforov.testing_sber.t2016.c3_ooconcepts;

/**
 * Created by Zigzag on 16.10.2016.
 */
public enum EnumInterfaceTest implements SomeInterface {

    VALUE_1("VALUE_1") {
        String v_name;

        @Override
        public String getName() {
            return v_name;
        }

        @Override
        public void setName(String name) {
            this.v_name = name;
        }
    }, VALUE_2("VALUE_2") {
        @Override
        public String getName() {
            return name;
        }

        @Override
        public void setName(String name) {
            this.name = name;
        }
    };

    String name;

    EnumInterfaceTest(String name) {
        this.name = name;
    }


    public static void main(String[] args) {
        System.out.println(VALUE_1.getName());
        VALUE_1.setName("NEW_NAME");
        System.out.println(VALUE_1.getName());
    }
}
