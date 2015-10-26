/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.core.parsedate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author mnikiforov
 */
public class QueueTest {

    private static DateFormat formatter = new SimpleDateFormat("MM/dd/yy HH:mm");

    public static void main(String[] args) throws ParseException {
        Date dateFrom = formatter.parse("06/26/14 08:00");
        System.out.println("dateFrom : " + dateFrom);
        Date dateTo = formatter.parse("06/26/14 21:00");
        System.out.println("dateTo : " + dateTo);
        System.out.println(isAvailableToReg(dateFrom, dateTo));
    }

    private static boolean isAvailableToReg(Date dateFrom, Date dateTo) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateFrom);
        int from = cal.get(Calendar.HOUR_OF_DAY) * 60 + cal.get(Calendar.MINUTE);
        System.out.println("cal.get(Calendar.HOUR)=" + cal.get(Calendar.HOUR) + " cal.get(Calendar.MINUTE)=" + cal.get(Calendar.MINUTE));
        cal.setTime(dateTo);
        int to = cal.get(Calendar.HOUR_OF_DAY) * 60 + cal.get(Calendar.MINUTE);
        System.out.println("cal.get(Calendar.HOUR)=" + cal.get(Calendar.HOUR) + " cal.get(Calendar.MINUTE)=" + cal.get(Calendar.MINUTE));
        cal.setTimeInMillis(System.currentTimeMillis());
        System.out.println("cal.getTime() : " + cal.getTime());
        int now = cal.get(Calendar.HOUR_OF_DAY) * 60 + cal.get(Calendar.MINUTE);
        System.out.println("from=" + from + " now=" + now + " to=" + to);

        return from < now && now < to;
    }
}
