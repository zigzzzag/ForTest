/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.maps;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mnikiforov
 */
public class DeleteByValue {

    public static void main(String[] args) {
	Map<String, String> map = new HashMap<String, String>();
	map.put("1", "One");
	map.put("2", "Two");
	map.put("3", "Three");
	System.out.println(map);
	map.values().remove("Three");
	System.out.println(map);
    }
}
