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
public class A {

    private String name;
    private B b;

    public A(String name, B b) {
	this.name = name;
	this.b = b;
    }

    public B getB() {
	return b;
    }

    public void setB(B b) {
	this.b = b;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }
}
