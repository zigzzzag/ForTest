package com.mnikiforov.testing_sber.t2016.c8_multithreading;

/**
 * Created by zigzzzag on 10/21/16.
 */
public class WriterReaderTest_Trash {
    private static String message;
    static Object monitor = Reader.class;

    static class Reader extends Thread {
        @Override
        public void run() {
            System.out.println("reader start: " + Thread.currentThread().getName());
            for (int i = 0; i < 10; i++) {
                synchronized (monitor) {
//                    monitor.notifyAll();
//                    System.out.println("reader monitor.notifyAll()");
                    try {
                        while (message == null) {
                            monitor.wait();
                            System.out.println("reader wait: " + Thread.currentThread().getName());


                        }
                    } catch (InterruptedException e) {
                    }
                    System.out.println(message);
                    message = null;
                }
            }
        }
    }

    static class Writer extends Thread {
        @Override
        public void run() {
            System.out.println("writer start: " + Thread.currentThread().getName());
            synchronized (monitor) {
                try {
                    while (message == null) {
//                        monitor.notifyAll();
//                        System.out.println("writer monitor.notifyAll()");

                        System.out.println("writer wait: " + Thread.currentThread().getName());
                        monitor.wait();

                    }
                } catch (InterruptedException e) {
                    message = "hello";
                }
            }
        }
    }

    public static void main(String[] args) {
        Reader reader = new Reader();
        reader.start();
        reader.interrupt();

        for (int i = 0; i < 10; i++) {
            Writer writer = new Writer();
            writer.start();
            writer.interrupt();
        }
    }
}