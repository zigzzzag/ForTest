package com.mnikiforov.multithreading;

import java.util.concurrent.Callable;

public class CallableTest {

    public static void main(String[] args) throws Exception {
        class HelloWorldCallble implements Callable<String> {

            @Override
            public String call() throws Exception {
                Thread.sleep(200);
                System.err.println("sleep 200");

                Thread.sleep(200);
                System.err.println("sleep 400");

                Thread.sleep(200);
                System.err.println("sleep 600");

                return "Hello world";
            }
        }

        Callable<String> c = new HelloWorldCallble();
        System.err.println(c.call());
    }
}
