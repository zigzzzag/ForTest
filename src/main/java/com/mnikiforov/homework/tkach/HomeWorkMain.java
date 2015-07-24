package com.mnikiforov.homework.tkach;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by SBT-Nikiforov-MO on 24.07.2015.
 */
public class HomeWorkMain {

    private static final Logger log = LoggerFactory.getLogger(HomeWorkMain.class);
    private static final String FILE_NAME = "holidays.txt";
    private static final String DATE_FORMAT_STR = "yyyy/M/d";
    private Set<Holiday> holidays;

    public static void main(String[] args) {
        HomeWorkMain homeWorkMain = new HomeWorkMain();
        homeWorkMain.showHolidays("01.01.2013", new SimpleDateFormat("dd.MM.yyyy"), 2);
    }

    public HomeWorkMain() {
        this.holidays = parseFile();
    }

    public void showHolidays(String dateStr, SimpleDateFormat sdf, int countDay) {
        try {
            Date fromDate = sdf.parse(dateStr);
            Calendar c = Calendar.getInstance();
            c.setTime(fromDate);
            c.add(Calendar.DATE, countDay);
            Date toDate = c.getTime();
            showHolidays(fromDate, toDate, sdf);
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
        }
    }

    public void showHolidays(Date fromDate, Date toDate, SimpleDateFormat sdf) {
        log.info("{} - {}", sdf.format(fromDate), sdf.format(toDate));
        for (Holiday hol : holidays) {
            if (fromDate.compareTo(hol.getDate()) <= 0 && hol.getDate().compareTo(toDate) <= 0) {
                log.info(hol.toString());
            }
        }
    }

    private Set<Holiday> parseFile() {
        Set<Holiday> result = new TreeSet<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_NAME), "UTF-8"))) {
            String lineStr = br.readLine();
            while (lineStr != null) {
                try {
                    Holiday hol = parseLine(lineStr);
                    result.add(hol);
                } catch (ParseException e) {
                    log.error(e.getMessage(), e);
                }
                lineStr = br.readLine();
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return result;
    }

    private Holiday parseLine(String lineStr) throws ParseException {
        int splitIndex = lineStr.indexOf(" ");
        String dateStr = lineStr.substring(0, splitIndex);
        String holidayName = lineStr.substring(splitIndex + 1);

        Date holidayDate = new SimpleDateFormat(DATE_FORMAT_STR).parse(dateStr);

        return new Holiday(holidayName, holidayDate);
    }
}
