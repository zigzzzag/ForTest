package com.mnikiforov.fortest;

import com.mnikiforov.tzupdatertest.TimeZoneUpdater;
import junit.framework.TestCase;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by SBT-Nikiforov-MO on 24.08.2015.
 */
public class CompareTZVersionTest extends TestCase {

    private final List<String> TZ_VERSIONS = Arrays.asList(
            "tzdata2005m", "tzdata2005n",
            "tzdata2006a", "tzdata2006d", "tzdata2006g", "tzdata2006k", "tzdata2006p",
            "tzdata2007a", "tzdata2007e", "tzdata2007f", "tzdata2007g", "tzdata2007h", "tzdata2007i", "tzdata2007j", "tzdata2007k",
            "tzdata2008b", "tzdata2008c", "tzdata2008e", "tzdata2008f", "tzdata2008g", "tzdata2008h", "tzdata2008i",
            "tzdata2009a", "tzdata2009b", "tzdata2009c", "tzdata2009e", "tzdata2009f", "tzdata2009g", "tzdata2009h", "tzdata2009i", "tzdata2009j", "tzdata2009k", "tzdata2009l", "tzdata2009m", "tzdata2009n", "tzdata2009o", "tzdata2009p", "tzdata2009q", "tzdata2009r", "tzdata2009s", "tzdata2009t", "tzdata2009u",
            "tzdata2010b", "tzdata2010c", "tzdata2010d", "tzdata2010e", "tzdata2010f", "tzdata2010g", "tzdata2010h", "tzdata2010i", "tzdata2010j", "tzdata2010k", "tzdata2010l", "tzdata2010m", "tzdata2010n", "tzdata2010o",
            "tzdata2011a", "tzdata2011b", "tzdata2011c", "tzdata2011d", "tzdata2011e", "tzdata2011f", "tzdata2011g", "tzdata2011h", "tzdata2011i", "tzdata2011j", "tzdata2011k", "tzdata2011l", "tzdata2011m", "tzdata2011n",
            "tzdata2012a", "tzdata2012b", "tzdata2012c", "tzdata2012d", "tzdata2012e", "tzdata2012f", "tzdata2012g", "tzdata2012h", "tzdata2012i", "tzdata2012j",
            "tzdata2013a", "tzdata2013b", "tzdata2013c", "tzdata2013d", "tzdata2013e", "tzdata2013f", "tzdata2013g", "tzdata2013h", "tzdata2013i",
            "tzdata2014a", "tzdata2014b", "tzdata2014c", "tzdata2014d", "tzdata2014e", "tzdata2014f", "tzdata2014g", "tzdata2014h", "tzdata2014i", "tzdata2014j",
            "tzdata2015a", "tzdata2015b", "tzdata2015c", "tzdata2015d", "tzdata2015e", "tzdata2015f"
    );

    public void testCompareTZVersion() throws IOException {
        String currentTZDataVersion = TimeZoneUpdater.INSTANCE.getTzDataVersion();
        System.out.println("currentTZDataVersion: " + currentTZDataVersion);

        int idx = TZ_VERSIONS.indexOf(currentTZDataVersion);
        for (int i = 0; i < TZ_VERSIONS.size(); i++) {
            String tzDataVersion = TZ_VERSIONS.get(i);
            if (i < idx) {
                if (currentTZDataVersion.compareTo(tzDataVersion) > 0) {
                    System.out.println(currentTZDataVersion + " > " + tzDataVersion);
                } else {
                    System.out.println("WARN! " + currentTZDataVersion + " <= " + tzDataVersion);
                }
            } else if (i == idx) {
                if (currentTZDataVersion.compareTo(tzDataVersion) == 0) {
                    System.out.println(currentTZDataVersion + " == " + tzDataVersion);
                } else {
                    System.out.println("WARN! " + currentTZDataVersion + " != " + tzDataVersion);
                }
            } else {
                if (currentTZDataVersion.compareTo(tzDataVersion) < 0) {
                    System.out.println(currentTZDataVersion + " < " + tzDataVersion);
                } else {
                    System.out.println("WARN! " + currentTZDataVersion + " >= " + tzDataVersion);
                }
            }
        }

        assertTrue(TZ_VERSIONS.contains(currentTZDataVersion));
    }
}
