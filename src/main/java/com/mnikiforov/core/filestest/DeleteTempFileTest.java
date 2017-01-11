package com.mnikiforov.core.filestest;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zigzzzag on 18.11.15.
 */
public class DeleteTempFileTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        File tempFile = File.createTempFile("test", ".txt");

        if (tempFile.delete()) {
            System.out.println("delete successfully");
        } else {
            System.out.println("delete fails");
        }

        tempFile.deleteOnExit();


        PrintWriter writer = new PrintWriter(tempFile);
        try {
            writer.write("Hello");
            writer.write("world");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }

        Thread.sleep(10_000);
    }
}
