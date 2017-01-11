package com.mnikiforov.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zigzzzag on 10/3/16.
 */
public class SimpleTestSerial extends Parent {

    private static final Logger LOG = LoggerFactory.getLogger(SimpleTestSerial.class);

    private byte version = 100;
    private byte count = 0;
    private SomeData someData = new SomeData();


    @Override
    public String toString() {
        return "SimpleTestSerial{" +
                "version=" + version +
                ", count=" + count +
                ", someData=" + someData +
                "} super:" + super.toString();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final String fileName = "temp.out";

        serialize(fileName);

        SimpleTestSerial ts = (SimpleTestSerial) deserialize(fileName);
        LOG.info(ts.toString());
    }

    private static Object deserialize(String fileName) throws IOException, ClassNotFoundException {
        Object result;
        try (FileInputStream fis = new FileInputStream(fileName)) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            result = ois.readObject();
        }
        return result;
    }

    private static void serialize(String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        SimpleTestSerial ts = new SimpleTestSerial();
        oos.writeObject(ts);
        oos.flush();
        oos.close();
    }
}
