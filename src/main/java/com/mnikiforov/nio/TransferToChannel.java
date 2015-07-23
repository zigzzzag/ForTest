/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mnikiforov
 */
public class TransferToChannel {

    public static void main(String[] args) {
	try {
	    RandomAccessFile fromFile = new RandomAccessFile("src/main/resources/data/fromFile.txt", "rw");
	    FileChannel fromChannel = fromFile.getChannel();

	    RandomAccessFile toFile = new RandomAccessFile("src/main/resources/data/toFile.txt", "rw");
	    FileChannel toChannel = toFile.getChannel();

	    long position = 0;
	    long count = fromChannel.size();

	    toChannel.transferTo(position, count, fromChannel);
	} catch (FileNotFoundException ex) {
	    Logger.getLogger(TransferFromChannel.class.getName()).log(Level.SEVERE, null, ex);
	} catch (IOException ex) {
	    Logger.getLogger(TransferFromChannel.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
}
