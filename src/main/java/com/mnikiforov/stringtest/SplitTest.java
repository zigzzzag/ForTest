package com.mnikiforov.stringtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by SBT-Nikiforov-MO on 26.03.2015.
 */
public class SplitTest {
    private static Logger log = LoggerFactory.getLogger(SplitTest.class);

    public static void main(String[] args) {
        String testString = "";
        String[] arr = testString.split(",");
        log.info("arr {}", ArrayAsString.convertArrayToString(arr));
    }
}
