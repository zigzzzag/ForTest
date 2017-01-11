package com.mnikiforov.interestingfacts;

/**
 * Created by zigzzzag on 26.03.2015.
 */
public class CompoundAssigmentOperator {

//    A compound assignment expression of the form E1 op= E2 is equivalent to E1 = (T)((E1) op (E2)),
//    where T is the type of E1, except that E1 is evaluated only once.

    public static void main(String[] args) {
        cao1();
    }

    private static void cao1() {
        byte a = 10;
        a *= 5.7;// a = a * 5.7 - not compiled!!!
        System.out.println(a);
    }
}
