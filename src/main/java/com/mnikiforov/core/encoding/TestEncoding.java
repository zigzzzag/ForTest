/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.core.encoding;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author mnikiforov
 */
public class TestEncoding {

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(
		new InputStreamReader(
			new FileInputStream("alphabet.cp1251"), "cp1251"));
	String str = br.readLine();
	System.out.println(str);
    }
}
