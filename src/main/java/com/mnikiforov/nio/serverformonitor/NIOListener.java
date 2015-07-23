/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.nio.serverformonitor;

/**
 *
 * @author mnikiforov
 */
public interface NIOListener {

    void onConnect();

    void onDisconnect();

    void onMessage(byte[] data);
}
