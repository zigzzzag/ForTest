package com.mnikiforov.tzupdatertest;

import java.io.IOException;

/**
 * Created by SBT-Nikiforov-MO on 21.08.2015.
 */
public class TimeZoneUpdater {

    private final String jreVersion = System.getProperty("java.version");
    private final String javaHome = System.getProperty("java.home");
    private static boolean jsr310;

    public static void main(String[] args) throws IOException {
        TimeZoneUpdater timeZoneUpdater = new TimeZoneUpdater();
        System.out.println(timeZoneUpdater.getTzDataVersion());
    }

    public TimeZoneUpdater() {
        int i = Integer.parseInt(this.jreVersion.substring(2, 3));
        if (i >= 8) {
            jsr310 = true;
        }
    }

    public String getTzDataVersion() throws IOException {
        String str2 = UtilsHelper.toTzdbFileName(this.javaHome);
        String currentID;
        if (!jsr310) {
            String zoneInfoDirName = UtilsHelper.toZiDirName(this.javaHome);
            if (zoneInfoDirName == null) {
                throw new RuntimeException("The Java runtime doesn't have time zone data (zi directory).");
            }
            currentID = UtilsHelper.getTzID(zoneInfoDirName);
        } else {
            currentID = UtilsHelper.getTzIDFromTZDB(str2);
        }
        return currentID;
    }
}
