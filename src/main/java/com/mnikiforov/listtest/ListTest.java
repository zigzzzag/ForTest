/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.listtest;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author mnikiforov
 */
public class ListTest {

    private static final Logger log = LoggerFactory.getLogger(ListTest.class);

    public static void main(String[] args) {
//	test1();
//	test2();
//	test3();
	concurrentRemoveTest();
    }

    private static void concurrentRemoveTest() {
	List<String> testList = new ArrayList<String>();
	for (int i = 0; i < 100; i++) {
	    if (i % 5 == 0) {
		testList.add(null);
	    } else {
		testList.add(i + "");
	    }
	}

	ListIterator<String> it = testList.listIterator();
	while (it.hasNext()) {
	    String str = it.next();
	    if (str == null) {
		it.remove();
	    }
	}
	log.info("councurentRemoveTest: testList.size() = {}", testList.size());
    }

    private static void test3() {
	List<String> testList = new ArrayList<String>();
	testList.add("String 1");
	testList.add("String 2");
	testList.add("String 3");
	testList.add("String 4");

	boolean r = testList.remove("String 666");
	System.out.println(r);
    }

    private static void test2() {
	List<String> testList = new ArrayList<String>();
	testList.add("String 1");
	testList.add("String 2");
	testList.add("String 3");
	testList.add("String 4");

	ListIterator<String> it = testList.listIterator();
	while (it.hasNext()) {
	    it.next();
	    testList.get(it.nextIndex() - 1).concat("q");
//	    System.out.println(it.nextIndex());
	}

	System.out.println("testList: " + testList);
    }

    private static void test1() {
	Cat cat1 = new Cat();
	Cat cat2 = new Cat();
	List<Cat> catList = new ArrayList<Cat>();
	catList.add(cat1);
	catList.add(cat2);

	Animal anCat1 = cat1;
	System.out.println(catList.contains(anCat1));
    }
}
