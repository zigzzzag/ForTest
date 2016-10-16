package com.mnikiforov.testing_sber.t2016.c3_ooconcepts;

/**
 * Created by Zigzag on 16.10.2016.
 */
public class EnumAbstractMethod {

    public enum Animal {
        CAT {
            public String makeNoise() {
                return "MEOW!";
            }
        },
        DOG {
            public String makeNoise() {
                return "WOOF!";
            }
        };

        public abstract String makeNoise();
    }

    public static void main(String[] args) {
        System.out.println(Animal.CAT.makeNoise());
    }
}
