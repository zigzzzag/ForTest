/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.core.finaltest;

/**
 *
 * @author mnikiforov
 */
// class Further extends TestFinal {} 
// error: Cannot extend final class 'TestFinal' 
public class FinalDemo {

    public static void main(String[] args) {
	TestFinal n = new TestFinal();
	n.f();
	n.i = 40;
	n.j++;
    }
}
