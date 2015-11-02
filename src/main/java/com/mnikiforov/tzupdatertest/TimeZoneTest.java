package com.mnikiforov.tzupdatertest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * Created by sbt-nikiforov-mo on 02.11.15.
 */
public class TimeZoneTest {

    static String str = "01.01.2015";

    public static void main(String[] args) throws ParseException {
        TimeZone tz1 = TimeZone.getTimeZone("GMT+3");
        TimeZone tz2 = TimeZone.getTimeZone("GMT+4");

        TimeZone.setDefault(tz1);
        System.out.println(new SimpleDateFormat("dd.MM.yyyy").parse(str).getTime());

        TimeZone.setDefault(tz2);
        System.out.println(new SimpleDateFormat("dd.MM.yyyy").parse(str).getTime());
    }
}
