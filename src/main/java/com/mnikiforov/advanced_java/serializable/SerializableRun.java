package com.mnikiforov.advanced_java.serializable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by SBT-Nikiforov-MO on 12.08.2015.
 */
public class SerializableRun {

    public static final String FILE_NAME = "store.bin";

    public static void main(String[] args) throws IOException {
        DataObject dataObject = new DataObject();
        dataObject.setMyData("its MY data!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        File file = new File(FILE_NAME);

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(dataObject);
        oos.flush();
        oos.close();
    }
}
