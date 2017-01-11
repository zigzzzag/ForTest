package com.mnikiforov.core.datetest.early_dates_test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by zigzzzag on 17.08.2015.
 */
public class EarlyDateTest {

    private static final String FILE_NAME = "dateSerializable.bin";

    public static void main(String[] args) throws ParseException, IOException, ClassNotFoundException {
        TimeZone defaultTimeZone = TimeZone.getDefault();
        defaultTimeZone.setID("GMT+03");
        TimeZone.setDefault(defaultTimeZone);

        //------------------------init------------------------------
        EarlyDateTest test = new EarlyDateTest();
        DatesSerializable ds = test.initDatesSerializable();
        System.out.println(ds);

        test.serialize(ds);

        defaultTimeZone.setID("Asia/Novosibirsk");
        defaultTimeZone.setRawOffset(10800000);
        TimeZone.setDefault(defaultTimeZone);

        DatesSerializable dsDeserializable = test.deserialize();
        System.out.println(dsDeserializable);
    }

    private DatesSerializable initDatesSerializable() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        DatesSerializable ds = new DatesSerializable();
        ds.setToday(new Date());
        ds.setBefore_26_10_2014(sdf.parse("25.10.2014 03:00:00"));
        ds.setNow_26_10_2014(sdf.parse("26.10.2014 00:00:00"));
        ds.setAfter_26_10_2014(sdf.parse("27.10.2014 03:00:00"));
        return ds;
    }

    private void serialize(DatesSerializable ds) throws IOException {
        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        try {
            oos.writeObject(ds);
            oos.flush();
        } finally {
            oos.close();
        }
    }

    private <T> T deserialize() throws IOException, ClassNotFoundException {
        T result;
        File file = new File(FILE_NAME);
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        try {
            result = (T) ois.readObject();
        } finally {
            ois.close();
        }
        return result;
    }
}
