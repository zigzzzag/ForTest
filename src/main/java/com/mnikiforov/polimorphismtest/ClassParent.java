/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.polimorphismtest;

/**
 *
 * @author mnikiforov
 */
public abstract class ClassParent {

    public void testVoid() {
	System.out.println("ClassParent: testVoid " + this.getClass().getSimpleName());
    }
}
