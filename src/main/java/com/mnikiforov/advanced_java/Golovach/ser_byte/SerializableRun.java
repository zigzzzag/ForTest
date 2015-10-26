package com.mnikiforov.advanced_java.Golovach.ser_byte;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by SBT-Nikiforov-MO on 12.08.2015.
 */
public class SerializableRun {

    public static final String FILE_NAME = "store.bin";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        serializable();
        deserilizable();
    }

    private static void deserilizable() throws IOException, ClassNotFoundException {
        System.out.println("deserializable start...");
        File file = new File(SerializableRun.FILE_NAME);
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        DataObject dataObject = (DataObject) ois.readObject();
        ois.close();

        System.out.println("deserializable finised!");
        System.out.println("result: " + dataObject);
    }

    private static void serializable() throws IOException {
        System.out.println("Serializable start...");

        DataObject dataObject = new DataObject();
        dataObject.setMyData("its MY data!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        File file = new File(FILE_NAME);

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(dataObject);
        oos.flush();
        oos.close();
        System.out.println("Serializable finished!");
    }
}
