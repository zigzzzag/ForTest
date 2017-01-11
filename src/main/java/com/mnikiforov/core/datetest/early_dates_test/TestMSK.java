package com.mnikiforov.core.datetest.early_dates_test;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by zigzzzag on 18.08.2015.
 */
public class TestMSK {

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("Europe/Moscow"));
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.US);
        df.setCalendar(c);

        c.setTimeInMillis(1413769091L * 1000L);
        if (!df.format(c.getTime()).equals("Monday, October 20, 2014 5:38:11 AM MSK")) {
            System.out.println("FAIL1 - 20 Oct is not in sync ");
            System.out.println(df.format(c.getTime()));
            System.exit(1);
        }

        c.setTimeInMillis(1414633091L * 1000L);

        if (!df.format(c.getTime()).equals("Thursday, October 30, 2014 4:38:11 AM MSK")) {
            System.out.println("FAIL2 - 30 Oct is not in sync");
            System.out.println(df.format(c.getTime()));
            System.exit(2);
        }

        System.out.println("OK");
        System.exit(0);
    }
}
