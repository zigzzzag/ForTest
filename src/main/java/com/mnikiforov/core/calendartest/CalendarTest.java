/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.core.calendartest;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * @author mnikiforov
 */
public class CalendarTest {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Novosibirsk"));
        System.out.printf("\t\"year\" : \"%s\",\n", calendar.get(Calendar.YEAR));
        System.out.printf("\t\"month\" : \"%s\",\n", calendar.get(Calendar.MONTH));
        System.out.printf("\t\"day\" : \"%s\",\n", calendar.get(Calendar.DAY_OF_MONTH));
        System.out.printf("\t\"hour\" : \"%s\",\n", calendar.get(Calendar.HOUR_OF_DAY));
        System.out.printf("\t\"minute\" : \"%s\",\n", calendar.get(Calendar.MINUTE));
        System.out.printf("\t\"second\" : \"%s\",\n", calendar.get(Calendar.SECOND));
    }
}
