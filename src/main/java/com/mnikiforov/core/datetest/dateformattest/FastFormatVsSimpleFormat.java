package com.mnikiforov.core.datetest.dateformattest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.time.FastDateFormat;

/**
 * Created by zigzzzag on 24.08.16.
 */
public class FastFormatVsSimpleFormat {

    private static List<Date> TEST_DATES = new ArrayList<>();
    private static List<String> TEST_DATES_STR = new ArrayList<>();
    private static final int DATES_COUNT = 100_000;
    private static final long HOUR = 60 * 60 * 1000;
    private static final String FORMAT = "dd.MM.yyyy mm:HH:ss";

    public static void main(String[] args) {
        long start = System.nanoTime();
        initData(DATES_COUNT);
        long totalTime = System.nanoTime() - start;
        System.out.println("init time: " + totalTime / 1_000_000 + " ms, TEST_DATES size: " + TEST_DATES.size());

        start = System.nanoTime();
        simpleDateTestFormat();
        totalTime = System.nanoTime() - start;
        System.out.printf("simpleDateTestFormat time: %sms\n", totalTime / 1_000_000);

        start = System.nanoTime();
        fastDateTestFormat();
        totalTime = System.nanoTime() - start;
        System.out.printf("fastDateTestFormat time:   %sms\n", totalTime / 1_000_000);

        start = System.nanoTime();
        simpleDateTestParse();
        totalTime = System.nanoTime() - start;
        System.out.printf("simpleDateTestParse time:  %sms\n", totalTime / 1_000_000);

        start = System.nanoTime();
        fastDateTestParse();
        totalTime = System.nanoTime() - start;
        System.out.printf("fastDateTestParse time:    %sms\n", totalTime / 1_000_000);
    }

    private static void fastDateTestParse() {
        for (String date : TEST_DATES_STR) {
            try {
                Date res = FastDateFormat.getInstance(FORMAT).parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    private static void simpleDateTestParse() {
        for (String date : TEST_DATES_STR) {
            try {
                Date res = new SimpleDateFormat(FORMAT).parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    private static void fastDateTestFormat() {
        for (Date date : TEST_DATES) {
            String res = FastDateFormat.getInstance(FORMAT).format(date);
        }
    }

    private static void simpleDateTestFormat() {
        for (Date date : TEST_DATES) {
            String res = new SimpleDateFormat(FORMAT).format(date);
        }
    }

    private static List<Date> initData(int count) {
        for (int i = 0; i < count; i++) {
            Date date = new Date(i * HOUR);
            TEST_DATES.add(date);
            //интересно, что время меняется если использовать разные форматеры для инициализации :)
            if (i % 2 == 0) {
                TEST_DATES_STR.add(new SimpleDateFormat(FORMAT).format(date));
            } else {
                TEST_DATES_STR.add(FastDateFormat.getInstance(FORMAT).format(date));
            }
        }

        return TEST_DATES;
    }
}
