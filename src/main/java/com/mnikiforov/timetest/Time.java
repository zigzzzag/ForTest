/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.timetest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 *
 * @author mnikiforov
 */
public class Time {

        private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        protected static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy, EEEE, zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");

        public static void main(String[] args) {
                parseLongToTimeTest();
        }

        private static void parseLongToTimeTest() {
                Calendar cal = Calendar.getInstance();

                long currTime = (System.currentTimeMillis());
                System.out.println("currentTime: " + String.format("%02d:%02d:%02d",
                        (currTime / (1000 * 60 * 60)) % 24,
                        (currTime / (1000 * 60)) % 60,
                        (currTime / 1000) % 60));

                long timeLong = 5 * 60 * 1000 + 30 * 1000;
                Date date = new Date(timeLong);
                System.out.println(timeFormat.format(date));
        }

        private void test1() {
                Date date = new Date(System.currentTimeMillis());
                System.out.println(Locale.getDefault().getCountry());

                System.out.println("TimeZone.getDefault().getID() = " + TimeZone.getDefault().getID());
                System.out.println("timeFormat.format(date)" + timeFormat.format(date));
                System.out.println("dateFormat.format(date)" + dateFormat.format(date));

                System.out.println(getMinutesUntilEndOfDay());
        }

        public static int getMinutesUntilEndOfDay() {
                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.SECOND, 0);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.HOUR_OF_DAY, 0);
                cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 1);
                return (int) (cal.getTimeInMillis() - System.currentTimeMillis()) / (1000 * 60);
        }
}
