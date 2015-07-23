/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.parsedate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author mnikiforov
 */
public class ParseDateTest {

    public static final SimpleDateFormat REPORT_DATE_FORMAT = new SimpleDateFormat("dd MMMMM yyyy", new Locale("ru"));

    public static void main(String[] args) {
	Date date = new Date();
	System.out.println(REPORT_DATE_FORMAT.format(date));
    }

    private static void test1() {
	SimpleDateFormat sd = new SimpleDateFormat("dd.MM.yyyy HH:mm");
	try {
	    Date regtime = new Date(sd.parse("16.04.2014 15:30").getTime());
	    System.out.println(sd.format(regtime));

	    sd.format(null);
	} catch (ParseException ex) {
	    ex.printStackTrace();
	}
    }
}
