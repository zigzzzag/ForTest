package com.mnikiforov.advanced_java.multithreading;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zigzzzag on 10/24/16.
 */
public class NotifyAllTest {

    public static void main(String[] args) {
        Object sync = new Object();
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new WaitingRunnable(sync));
            t.start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.err.println("main::  Interrupted: " + ex.getMessage());
        }
        synchronized (sync) {
            log("main::  Calling notifyAll");
            sync.notifyAll();
            log("main::  Sleeping for 3 seconds");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                System.err.println("main::  Interrupted: " + ex.getMessage());
            }
            log("main::  Exiting synchronized block");
        }
    }

    static void log(String msg) {
        System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()) + ": " + msg);
    }

    static class WaitingRunnable implements Runnable {

        static int nextId = 1;

        private Object sync;
        private int id;

        public WaitingRunnable(Object sync) {
            this.sync = sync;
            id = nextId++;
        }

        @Override
        public void run() {
            synchronized (sync) {
                log("own(" + id + ")::Waiting");
                try {
                    sync.wait();
                } catch (InterruptedException ex) {
                    log("own(" + id + ")::Interrupted: " + ex.getMessage());
                }
                log("own(" + id + ")::Running again");
                log("own(" + id + ")::Sleeping for 1 second");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    log("own(" + id + ")::Interrupted: " + ex.getMessage());
                }
                log("own(" + id + ")::Finishing");
            }
        }
    }
}
