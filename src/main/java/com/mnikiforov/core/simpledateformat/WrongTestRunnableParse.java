package com.mnikiforov.core.simpledateformat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zigzzzag on 27.03.2015.
 */
public class WrongTestRunnableParse implements Runnable {
    private static final int countIter = 100;
    private SimpleDateFormat sdf;
    private String dateStr;

    public WrongTestRunnableParse(SimpleDateFormat simpleDateFormat, String dateStr) {
        this.sdf = simpleDateFormat;
        this.dateStr = dateStr;
    }

    @Override
    public void run() {
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
