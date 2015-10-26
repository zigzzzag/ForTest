package com.mnikiforov.core.fortest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Hello world!
 *
 */
public class App {

    private static Object M1() {
	System.out.println("1");
	return "Test";
    }
    
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws Exception {
	M1();
	lock.lock();
	try {
	    M1();
	    throw new Exception("Test");
	} finally {
	    lock.unlock();
	    M1();
	}
    }

}
