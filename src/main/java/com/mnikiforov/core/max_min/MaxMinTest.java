package com.mnikiforov.core.max_min;

import org.apache.commons.lang.ObjectUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by zigzzzag on 03.06.16.
 */
public class MaxMinTest {

    public static void main(String[] args) throws InterruptedException {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1970);
        Date date1 = cal.getTime();
        Thread.sleep(10);
        Date date2 = new Date();

        System.out.println("max = " + ObjectUtils.max(date1, date2));
        System.out.println("min = " + ObjectUtils.min(date1, date2));
    }
}
