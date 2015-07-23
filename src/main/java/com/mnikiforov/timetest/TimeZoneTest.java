/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.timetest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 *
 * @author mnikiforov
 */
public class TimeZoneTest {

    public static void main(String[] args) {
//	Calendar c = Calendar.getInstance(TimeZone.getTimeZone("Asia/Novosibirsk"));
	Calendar c = Calendar.getInstance();
	DateFormat df = new SimpleDateFormat();
	df.setCalendar(c);

//	c.setTimeInMillis(1413769091L * 1000L);
//	if (!df.format(c.getTime()).equals("Monday, October 20, 2014 5:38:11 AM MSK")) {
//	    System.out.println("FAIL1 - 20 Oct is not in sync ");
//	    System.out.println(df.format(c.getTime()));
//	    System.exit(1);
//	}
//
//	c.setTimeInMillis(1414633091L * 1000L);
//	if (!df.format(c.getTime()).equals("Thursday, October 30, 2014 4:38:11 AM MSK")) {
//	    System.out.println("FAIL2 - 30 Oct is not in sync");
//	    System.out.println(df.format(c.getTime()));
//	    System.exit(2);
//	}
	System.out.println(df.format(new Date()));
	System.exit(0);
    }
}
