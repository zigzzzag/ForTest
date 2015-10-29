package com.mnikiforov.trash.sber;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by sbt-nikiforov-mo on 29.10.15.
 */
public class PrintWriterTest {

    public static void main(String[] args) throws IOException {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
        System.out.println(cal.getTime().getHours());
    }

    private static void test() throws IOException {
        BufferedOutputStream[] p = new BufferedOutputStream[5];

        for (int i = 0; i < 5; i++) {
            p[i] = new BufferedOutputStream(System.out);
        }
        for (BufferedOutputStream e : p) {
            System.out.println("qqq");
            e.write(1);
            e.close();
        }
    }
}
