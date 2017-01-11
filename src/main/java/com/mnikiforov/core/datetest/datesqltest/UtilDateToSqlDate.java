package com.mnikiforov.core.datetest.datesqltest;


/**
 * Created by zigzzzag on 27.06.16.
 */
public class UtilDateToSqlDate {

    public static void main(String[] args) {
        java.util.Date today = new java.util.Date();
        System.out.println("util: " + today + ", sql: " + convertToSqlDate(today));
    }

    public static java.sql.Date convertToSqlDate(java.util.Date utilDate) {
        return new java.sql.Date(utilDate.getTime());
    }
}
