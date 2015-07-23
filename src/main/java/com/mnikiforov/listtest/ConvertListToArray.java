/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.listtest;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mnikiforov
 */
public class ConvertListToArray {

    public static void main(String[] args) {
	List<Object> objList = new ArrayList<Object>();
	objList.add("1");
	objList.add("2");
	objList.add("3");

	Object[] arr = new Object[objList.size()];
	convertListToArray(objList, arr);

	System.out.println(objList);
	for (int i = 0; i < arr.length; i++) {
	    System.out.print(arr[i] + ", ");
	}
	System.out.println("");
    }

    public ConvertListToArray() {
    }

    public static void convertListToArray(List<Object> list, Object[] arr) {
	for (int i = 0; i < list.size(); i++) {
	    arr[i] = list.get(i);
	}
    }
}
