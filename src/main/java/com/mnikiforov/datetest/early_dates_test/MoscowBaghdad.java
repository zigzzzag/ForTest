package com.mnikiforov.datetest.early_dates_test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by SBT-Nikiforov-MO on 18.08.2015.
 */
public class MoscowBaghdad {

    private static final String MOSCOW = "Europe/Moscow";
    private static final String BAGHDAD = "Asia/Baghdad";

    public static void main(String[] args) throws ParseException {
        TimeZone tz = TimeZone.getDefault();
//        tz.setID(MOSCOW);

        System.out.println(tz);

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        System.out.println("25_10_2014: " + sdf.parse(TimeZoneTest.d25_10_2014).getTime());
        System.out.println("26_10_2014: " + sdf.parse(TimeZoneTest.d26_10_2014).getTime());
        System.out.println("27_10_2014: " + sdf.parse(TimeZoneTest.d27_10_2014).getTime());

        System.out.println("------------------------------------------------------------");

        System.out.println(sdf.format(new Date(1414180800000L)));
        System.out.println(sdf.format(new Date(1414267200000L)));
        System.out.println(sdf.format(new Date(1414357200000L)));

//        for (String tzStr : TimeZone.getAvailableIDs()) {
//            System.out.println(TimeZone.getTimeZone(tzStr));
//        }
    }

//    sun.util.calendar.ZoneInfo[id="Europe/Moscow",offset=10800000,dstSavings=0,useDaylight=false,transitions=79,lastRule=null]
//    25_10_2014: 1414180800000
//    26_10_2014: 1414267200000
//    27_10_2014: 1414357200000

//    sun.util.calendar.ZoneInfo[id="Asia/Baghdad",offset=10800000,dstSavings=0,useDaylight=false,transitions=55,lastRule=null]
//    25_10_2014: 1414184400000
//    26_10_2014: 1414270800000
//    27_10_2014: 1414357200000

//    sun.util.calendar.ZoneInfo[id="Europe/Moscow",offset=10800000,dstSavings=0,useDaylight=false,transitions=55,lastRule=null]
//    25_10_2014: 1414184400000
//    26_10_2014: 1414270800000
//    27_10_2014: 1414357200000
}
