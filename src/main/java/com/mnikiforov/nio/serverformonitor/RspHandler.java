/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.nio.serverformonitor;

/**
 *
 * @author mnikiforov
 */
public class RspHandler {

    private byte[] rsp = null;

    public synchronized boolean handleResponse(byte[] rsp) {
        this.rsp = rsp;
        this.notify();
        return true;
    }

    public synchronized void waitForResponse() {
        while (this.rsp == null) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }

        System.out.println(new String(this.rsp));
    }
}
