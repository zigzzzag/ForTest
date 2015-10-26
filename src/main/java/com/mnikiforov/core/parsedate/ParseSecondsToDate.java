/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.core.parsedate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author mnikiforov
 */
public class ParseSecondsToDate {

    public static void main(String[] args) {
        SimpleDateFormat stf = new SimpleDateFormat("HH:mm:ss");
        long sec = 3600 * 1000;
        System.out.println(stf.format(new Date(sec)));
        System.out.println(parseMillis(sec));
        sec = 6 * 60 * 1000 + 32 * 1000;
        System.out.println(stf.format(new Date(sec)));

        System.out.println(parseMillis(sec));
    }

    public static String parseMillis(long milliseconds) {
        return String.format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(milliseconds) % 60,
                TimeUnit.MILLISECONDS.toMinutes(milliseconds) % 60,
                TimeUnit.MILLISECONDS.toSeconds(milliseconds) % 60
        );
    }
}
