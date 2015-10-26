package com.mnikiforov.rmi.server.compute;

/**
 * Created by Zigzag on 27.10.2015.
 */
public interface Task<T> {

    T execute();
}
