package com.mnikiforov.testing_sber.t2016.c8_multithreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by zigzzzag on 10/24/16.
 */
public class ListMultiThreadTest {

    //    static List<String> list = Collections.synchronizedList(new ArrayList<String>());
    static List<String> list = new ArrayList<String>();

    static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100_000; i++) {
                synchronized (list) {
                    list.add("item" + i);
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new MyThread().start();
        }
    }
}
