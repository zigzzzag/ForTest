package com.mnikiforov.datetest.early_dates_test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by SBT-Nikiforov-MO on 18.08.2015.
 */
public class TimeZoneTest {

    static final String d25_10_2014 = "25.10.2014 00:00:00";
    static final String d26_10_2014 = "26.10.2014 00:00:00";
    static final String d27_10_2014 = "27.10.2014 00:00:00";
    private static final long HOUR_1 = 1 * 60 * 60 * 1000;

    public static void main(String[] args) throws ParseException {
        TimeZone defaultTimeZone = TimeZone.getDefault();

        System.out.println(defaultTimeZone);
        printTestDate();

        TimeZone defaultTimeZone2 = TimeZone.getDefault();
        defaultTimeZone2.setRawOffset(10800000);
        TimeZone.setDefault(defaultTimeZone2);

        System.out.println(defaultTimeZone2);
        printTestDate();
    }

    private static void printTestDate() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        System.out.println(sdf.parse(d25_10_2014).getTime() + " " + sdf.format(new Date(1414184400000L - HOUR_1)));
        System.out.println(sdf.parse(d26_10_2014).getTime() + " " + sdf.format(new Date(1414270800000L - HOUR_1)));
        System.out.println(sdf.parse(d27_10_2014).getTime() + " " + sdf.format(new Date(1414360800000L - HOUR_1)));

        System.out.println(sdf.format(new Date(1414173600000L)));
        System.out.println(TimeZone.getDefault().useDaylightTime());
        System.out.println(TimeZone.getDefault().getDSTSavings());
    }
}
