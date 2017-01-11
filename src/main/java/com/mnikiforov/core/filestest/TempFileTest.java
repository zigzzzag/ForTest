package com.mnikiforov.core.filestest;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zigzzzag on 16.11.15.
 */
public class TempFileTest {

    public static void main(String[] args) throws IOException {
        File file = File.createTempFile("test", ".txt");

        PrintWriter writer = new PrintWriter(file);
        try {
            writer.write("Hello");
            writer.write("world");
        } finally {
            writer.close();
        }
    }
}
