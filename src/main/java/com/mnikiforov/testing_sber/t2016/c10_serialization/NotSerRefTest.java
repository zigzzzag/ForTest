package com.mnikiforov.testing_sber.t2016.c10_serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by zigzzzag on 10/24/16.
 */
public class NotSerRefTest implements Serializable {

    NotSerClass nsc = new NotSerClass();

    public static void main(String[] args) {
        NotSerRefTest tst = new NotSerRefTest();
        try {
            FileOutputStream fs = new FileOutputStream("b.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fs);
            oos.writeObject(tst);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
