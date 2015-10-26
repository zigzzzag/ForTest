/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.core.polimorphismtest;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mnikiforov
 */
public class PolimorphMainClass {

    public static void main(String[] args) {
	List<ClassParent> testList = new ArrayList<ClassParent>();
	testList.add(new ClassA());
	testList.add(new ClassB());

	for (ClassParent classParent : testList) {
	    classParent.testVoid();
	}
    }
}
