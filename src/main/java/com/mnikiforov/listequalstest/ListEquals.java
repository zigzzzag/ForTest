/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.listequalstest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author mnikiforov
 */
public class ListEquals {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        list1.add("a");
        list1.add("b");

        list2.add("b");
        list2.add("a");
        System.out.println(list1.equals(list2));

        Set<String> set1 = new HashSet<String>();
        Set<String> set2 = new HashSet<String>();
        set1.add("a");
        set1.add("b");

        set2.add("b");
        set2.add("a");
        System.out.println(set1.equals(set2));
    }
}
