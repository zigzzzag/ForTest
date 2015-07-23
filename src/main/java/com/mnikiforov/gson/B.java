/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.gson;

/**
 *
 * @author mnikiforov
 */
public class B {

    private String str;
    private int count;
    private A a;

    public B(String str, int count) {
	this.str = str;
	this.count = count;
    }

    public String getStr() {
	return str;
    }

    public void setStr(String str) {
	this.str = str;
    }

    public int getCount() {
	return count;
    }

    public void setCount(int count) {
	this.count = count;
    }

    public A getA() {
	return a;
    }

    public void setA(A a) {
	this.a = a;
    }
}
