package com.mnikiforov.interestingfacts;

/**
 * Created by SBT-Nikiforov-MO on 26.03.2015.
 */
public class ConditionalOperator {

    public static void main(String[] args) {
        //на первый взгляд condOperQ и condOper должны выводить одинаковый результат
        //но нет!!! condOperQ 1.0   condOper 1
        condOperQ();
        condOper();

        condOperNPE();
    }

    private static void condOperQ() {
        Object o = true ? new Integer(1) : new Double(0);
        System.out.println("condOperQ: " + o);
    }

    private static void condOper() {
        Object o;
        if (true) {
            o = new Integer(1);
        } else {
            o = new Double(0);
        }
        System.out.println("condOper: " + o);
    }

    private static void condOperNPE() {
        Integer i = new Integer(1);
        if (i.equals(1)) {
            i = null;
        }
        Double d = new Double(0);
        Object o = true ? i : d;
        System.out.println("condOperNPE: " + o);
    }
}
