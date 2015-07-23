/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.trycatchtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author mnikiforov
 */
public class TryCatchTest {

    private static Logger log = LoggerFactory.getLogger(TryCatchTest.class);

    public static void main(String[] args) {
	try {
	    System.out.println("try1");
	    try {
		System.out.println("try2");
		int a = 1000 / 0;
		System.out.println("try2 after exception");
	    } finally {
		System.out.println("finally2");
	    }
	} catch (Exception ex) {
	    log.info("Exception");
	} finally {
	    System.out.println("finally1");
	}
    }
}
