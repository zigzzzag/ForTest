package com.mnikiforov.timezonetest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by SBT-Nikiforov-MO on 13.04.2015.
 */
public class TimeZoneTest {

    public static void main(String[] args) {
        TimeZone tzDefault = TimeZone.getDefault();
        int rawOffsetDefault = tzDefault.getRawOffset();

        System.out.println("before:");
        System.out.println("rawOffsetDefault: " + rawOffsetDefault);

        print();

        TimeZone tz = TimeZone.getTimeZone("Europe/Moscow");
        System.out.println(tz);
//        tz.setRawOffset(rawOffsetDefault);
        tz.setRawOffset(rawOffsetDefault - 60 * 60 * 1000);
        TimeZone.setDefault(tz);

//        TimeZone tz = TimeZone.getDefault();
//        tz.setRawOffset(rawOffsetDefault - 60 * 60 * 1000);
//        TimeZone.setDefault(tz);

        System.out.println("");
        System.out.println("after:");

        print();
    }

    private static void print() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        System.out.println("DisplayName: " + TimeZone.getDefault().getDisplayName());
        String timezoneID = TimeZone.getDefault().getID();
        System.out.println("ID:          " + timezoneID);
        System.out.println("rawOffset: " + TimeZone.getDefault().getRawOffset() + "ms");
        System.out.println("today: " + sdf.format(new Date()));
    }
}
