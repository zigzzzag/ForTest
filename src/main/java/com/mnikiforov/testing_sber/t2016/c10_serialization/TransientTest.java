package com.mnikiforov.testing_sber.t2016.c10_serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by sbt-nikiforov-mo on 10/24/16.
 */
public class TransientTest implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        A a = new A();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test.ser"));
        oos.writeObject(a);
        oos.close();
        System.out.print(a.b + " ");

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.ser"));
        A s2 = (A) ois.readObject();
        ois.close();
        System.out.println(s2.a + " " + s2.b);
    }
}
