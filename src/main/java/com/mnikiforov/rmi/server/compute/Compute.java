package com.mnikiforov.rmi.server.compute;


import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Zigzag on 27.10.2015.
 */
public interface Compute extends Remote {

    <T> T executeTask(Task<T> t) throws RemoteException;
}
