/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.spiltbigfile;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author mnikiforov
 */
public class SplitBigFile {

    private static final Logger log = LoggerFactory.getLogger(SplitBigFile.class);
    private static String pathToFileStr = "C:/MainProjects/errors/22.01.2015/";//C:\MainProjects\errors\20.12.2014

    public static void main(String[] args) throws Exception {
        try (RandomAccessFile raf = new RandomAccessFile(pathToFileStr + "catalina.out", "r")) {
            long numSplits = 10; //from user input, extract it from args
            long sourceSize = raf.length();
            long bytesPerSplit = sourceSize / numSplits;
            long remainingBytes = sourceSize % numSplits;

            int maxReadBufferSize = 8 * 1024; //8KB
            for (int destIx = 1; destIx <= numSplits; destIx++) {
                log.info("destIx = {}", destIx);
                BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream(pathToFileStr + "split." + destIx + ".txt"));
                if (bytesPerSplit > maxReadBufferSize) {
                    long numReads = bytesPerSplit / maxReadBufferSize;
                    long numRemainingRead = bytesPerSplit % maxReadBufferSize;
                    for (int i = 0; i < numReads; i++) {
                        readWrite(raf, bw, maxReadBufferSize);
                    }
                    if (numRemainingRead > 0) {
                        readWrite(raf, bw, numRemainingRead);
                    }
                } else {
                    readWrite(raf, bw, bytesPerSplit);
                }
                bw.close();
            }
            if (remainingBytes > 0) {
                BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream("split." + numSplits + 1));
                readWrite(raf, bw, remainingBytes);
                bw.close();
            }
        }
    }

    static void readWrite(RandomAccessFile raf, BufferedOutputStream bw, long numBytes) throws IOException {
        byte[] buf = new byte[(int) numBytes];
        int val = raf.read(buf);
        if (val != -1) {
            bw.write(buf);
        }
    }
}
