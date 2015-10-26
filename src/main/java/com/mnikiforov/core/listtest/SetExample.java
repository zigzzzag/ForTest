/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.core.listtest;

/**
 *
 * @author mnikiforov
 */
public class SetExample {

    private String title;

    public SetExample(String title) {
	this.title = title;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    @Override
    public String toString() {
	return title;
    }

}
