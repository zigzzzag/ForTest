package com.mnikiforov.simpledateformat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by SBT-Nikiforov-MO on 27.03.2015.
 */
public class RightTestRunnableParse implements Runnable {
    private static final int countIter = 100;
    private String dateStr;

    public RightTestRunnableParse(String dateStr) {
        this.dateStr = dateStr;
    }

    @Override
    public void run() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        for (int i = 0; i < countIter; i++) {
            try {
                Date date = sdf.parse(dateStr);
                System.out.println(Thread.currentThread().getName() + "    time " + date.getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
