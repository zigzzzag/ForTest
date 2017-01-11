package com.mnikiforov.tzupdatertest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * Created by zigzzzag on 02.11.15.
 */
public class TimeZoneTest {

    static String str_25 = "25.10.2014";
    static String str_26 = "26.10.2014";
    static String str_27 = "27.10.2014";

    public static void main(String[] args) throws ParseException {
        TimeZone gmt3 = TimeZone.getTimeZone("GMT+3");
        TimeZone moscow = TimeZone.getTimeZone("Europe/Moscow");

        System.out.println("GMT+3");
        TimeZone.setDefault(gmt3);
        System.out.print(new SimpleDateFormat("dd.MM.yyyy").parse(str_25).getTime() + " ");
        System.out.print(new SimpleDateFormat("dd.MM.yyyy").parse(str_26).getTime() + " ");
        System.out.print(new SimpleDateFormat("dd.MM.yyyy").parse(str_27).getTime() + " ");

        System.out.println();

        System.out.println("Europe/Moscow");
        TimeZone.setDefault(moscow);
        System.out.print(new SimpleDateFormat("dd.MM.yyyy").parse(str_25).getTime() + " ");
        System.out.print(new SimpleDateFormat("dd.MM.yyyy").parse(str_26).getTime() + " ");
        System.out.print(new SimpleDateFormat("dd.MM.yyyy").parse(str_27).getTime() + " ");
    }
}
