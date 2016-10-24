package com.mnikiforov.testing_sber.t2016.c10_serialization.constructor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by sbt-nikiforov-mo on 10/24/16.
 */
public class Test {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        B b = new B();
        ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream("data"));
        save.writeObject(b);
        save.flush();

        ObjectInputStream restore = new ObjectInputStream(new FileInputStream("data"));
        B z = (B) restore.readObject();
    }
}
