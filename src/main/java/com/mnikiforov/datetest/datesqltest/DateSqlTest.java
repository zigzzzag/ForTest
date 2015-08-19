package com.mnikiforov.datetest.datesqltest;

import java.sql.Date;

/**
 * Created by mnikiforov on 04.06.2015.
 */
public class DateSqlTest {
    public static void main(String[] args) {
        java.util.Date utilDate = new java.util.Date(System.currentTimeMillis());
        System.out.println("System.currentTimeMillis(): " + System.currentTimeMillis());
        System.out.println("utilDate:                   " + utilDate.getTime());

        System.out.println();

        Date sqlToDate = new Date(System.currentTimeMillis());
        System.out.println("System.currentTimeMillis(): " + System.currentTimeMillis());
        System.out.println("sqlDate:                    " + sqlToDate.getTime());

// I live in Zurich, which is CET, not GMT. So the following prints -3600000,
// which is CET 1970-01-01 00:00:00
// ... or   GMT 1969-12-31 23:00:00
//        System.out.println(rs.getDate(1).getTime());
    }
}
