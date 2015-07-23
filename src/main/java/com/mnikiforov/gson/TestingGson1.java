/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.gson;

import com.google.gson.Gson;

/**
 *
 * @author mnikiforov
 */
public class TestingGson1 {

    public static void main(String[] args) {
	B b = new B("hello", 100);
	A a = new A("A", b);

	System.out.println(new Gson().toJson(a));
	a.setB(null);
	System.out.println(new Gson().toJson(a));
    }
}
