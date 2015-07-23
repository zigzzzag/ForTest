/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.stringtest;

/**
 *
 * @author mnikiforov
 */
public class LinkStringTest {

    public static void main(String[] args) {
	String error = "error";
	System.out.println(error.hashCode() + " " + error);
	changeString1(error);
	System.out.println(error.hashCode() + " " + error);

	System.out.println("");

	StringBuilder errorSB = new StringBuilder("error");
	System.out.println(errorSB.hashCode() + " " + errorSB.toString());
	changeString2(errorSB);
	System.out.println(errorSB.hashCode() + " " + errorSB.toString());
    }

    private static void changeString2(StringBuilder errorSB) {
	errorSB.delete(0, errorSB.toString().length());
	errorSB.append("new error");
	System.out.println("changeString2: " + errorSB.hashCode() + " " + errorSB.toString());
    }

    private static void changeString1(String error) {
	error = "new error";
	System.out.println("changeString1: " + error.hashCode() + " " + error);
    }
}
