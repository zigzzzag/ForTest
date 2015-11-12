/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.core.datetest.dateformattest;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author mnikiforov
 */
public class DateFormatTest {

    public static void main(String[] args) {
	SimpleDateFormat sdf1 = new SimpleDateFormat("MMMM yyyy");
	SimpleDateFormat sdf2 = new SimpleDateFormat("M yyyy");
	SimpleDateFormat sdf3 = new SimpleDateFormat("MMMMM yyyy");
	SimpleDateFormat sdf4 = new SimpleDateFormat("mm yyyy");
	Date date = new Date();
	System.out.println(sdf1.toPattern() + ": " + sdf1.format(date));
	System.out.println(sdf2.toPattern() + ": " + sdf2.format(date));
	System.out.println(sdf3.toPattern() + ": " + sdf3.format(date));
	System.out.println(sdf4.toPattern() + ": " + sdf4.format(date));
    }
}
