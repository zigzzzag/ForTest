/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mnikiforov
 */
public class BasicChannelExample {

    public static void main(String[] args) {
	try {
	    RandomAccessFile aFile = new RandomAccessFile("src/main/resources/data/nio-data.txt", "rw");
	    FileChannel inChannel = aFile.getChannel();

	    ByteBuffer buf = ByteBuffer.allocate(48);

	    int bytesRead = inChannel.read(buf);
	    while (bytesRead != -1) {
		buf.flip();

		while (buf.hasRemaining()) {
		    System.out.print((char) buf.get());
		}

		buf.clear();
		bytesRead = inChannel.read(buf);
	    }
	    aFile.close();
	} catch (FileNotFoundException ex) {
	    Logger.getLogger(BasicChannelExample.class.getName()).log(Level.SEVERE, null, ex);
	} catch (IOException ex) {
	    Logger.getLogger(BasicChannelExample.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
}
