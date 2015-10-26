/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.core.listtest;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mnikiforov
 */
public class ListSetTest {

    public static void main(String[] args) {
	List<SetExample> testList = new ArrayList<SetExample>();

	SetExample e1 = new SetExample("e1");
	testList.add(e1);

	SetExample e2 = new SetExample("e2");
	testList.add(e2);

	SetExample e3 = new SetExample("e3");
	testList.add(e3);

	printList(testList);

	testList.set(1, e3);
	printList(testList);
    }

    private static void printList(List list) {
	for (Object o : list) {
	    System.out.print(o.toString() + " ");
	}
	System.out.println("");
    }
}
