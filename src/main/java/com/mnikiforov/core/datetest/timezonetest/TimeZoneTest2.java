package com.mnikiforov.core.datetest.timezonetest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by SBT-Nikiforov-MO on 30.07.2015.
 */
public class TimeZoneTest2 {

    private static final Logger log = LoggerFactory.getLogger(TimeZoneTest2.class);

    public static void main(String[] args) throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
//        Date testDate = sdf.parse("25.10.2014 00:00:00");
//
//        System.out.println("today: " + sdf.format(new Date()));
//        System.out.println("today: " + sdf.format(sdf.parse("25.10.2014 00:00:00")));
//        System.out.println(TimeZone.getDefault().getRawOffset() / 60000);

        TimeZone tz = TimeZone.getDefault();

        int rawOffset = 10800000;
        if (tz.useDaylightTime()) {
            rawOffset = rawOffset - tz.getDSTSavings();
        }

        log.debug("TimeZone use Daylight Time: {}", tz.useDaylightTime());
        log.debug("Raw Offset: " + rawOffset);
        log.debug("TimeZone: " + tz.getDisplayName() +
                ", offset: " + tz.getOffset(Calendar.getInstance().getTimeInMillis()) +
                ", calendar: " + Calendar.getInstance());

        tz.setRawOffset(rawOffset);
        tz.setID("GMT");
        TimeZone.setDefault(tz);

        TimeZone newtz = TimeZone.getDefault();
        log.debug("TimeZone: " + newtz.getDisplayName() +
                ", offset: " + newtz.getOffset(Calendar.getInstance().getTimeInMillis()) +
                ", calendar: " + Calendar.getInstance());
    }
}
