package com.mnikiforov.core.simpledateformat;

import java.text.SimpleDateFormat;

/**
 * Created by zigzzzag on 27.03.2015.
 */
public class SimpleDateFormatTest {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    private static final String DATE_STR = "27.03.2015 23:59:59";

    public static void main(String[] args) {
        SimpleDateFormatTest sdfTest = new SimpleDateFormatTest();

        sdfTest.rightVersion();
        System.out.println();
        sdfTest.wrongVersion();
    }

    private void rightVersion() {
        System.out.println("----- RIGHT VERSION START -----");
        RightTestRunnableParse rtr1 = new RightTestRunnableParse(DATE_STR);
        RightTestRunnableParse rtr2 = new RightTestRunnableParse(DATE_STR);

        testVoid(rtr1, rtr2);

        System.out.println("----- RIGHT VERSION END -----");
    }

    private void wrongVersion() {
        System.out.println("----- WRONG VERSION START -----");
        WrongTestRunnableParse wtr1 = new WrongTestRunnableParse(DATE_FORMAT, DATE_STR);
        WrongTestRunnableParse wtr2 = new WrongTestRunnableParse(DATE_FORMAT, DATE_STR);

        testVoid(wtr1, wtr2);

        System.out.println("----- WRONG VERSION END -----");
    }

    private <R extends Runnable> void testVoid(R r1, R r2) {
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

