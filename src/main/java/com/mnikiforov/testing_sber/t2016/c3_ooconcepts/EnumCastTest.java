package com.mnikiforov.testing_sber.t2016.c3_ooconcepts;

/**
 * Created by Zigzag on 16.10.2016.
 */
public class EnumCastTest {

    enum Spice {NUTMEG, CINNAMON, CORIANDER, ROSEMARY}

    public static void main(String[] args) {
        {
            Spice sp = Spice.NUTMEG;
            Object ob = (Object) sp;
        }

        {
            Spice sp = Spice.NUTMEG;
            Object ob = sp;
        }

        {
            Object ob = new Object();
//        Spice sp = object; //compile error
        }

        {
            Object ob = new Object();
            Spice sp = (Spice) ob;
        }
    }
}
