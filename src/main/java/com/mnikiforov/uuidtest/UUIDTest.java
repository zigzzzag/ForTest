/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.uuidtest;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.UUID;

/**
 *
 * @author mnikiforov
 */
public class UUIDTest {

    public static void main(String[] args) {

	long p = 3557;
	long q = 2579;
	
	long n = p*q;
	
	long f = (p-1)*(q-1);
	
	long e = 3;
		
	
	BigDecimal d = new BigDecimal(e);
	d= d.pow(-1);
//	d = d.
		
	long c = 100;
	long dc = (long) (Math.pow(c, e) % n);
//	long dcc = (long) (Math.pow(dc, d) % n);
	
	System.out.println(d);
	
	System.out.println(c);
	System.out.println(dc);
//	System.out.println(dcc);

    }

}
