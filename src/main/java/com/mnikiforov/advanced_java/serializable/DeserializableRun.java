package com.mnikiforov.advanced_java.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by SBT-Nikiforov-MO on 13.08.2015.
 */
public class DeserializableRun {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File(SerializableRun.FILE_NAME);
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        DataObject dataObject = (DataObject) ois.readObject();
        ois.close();

        System.out.println(dataObject);
    }
}
