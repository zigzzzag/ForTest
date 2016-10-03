package com.mnikiforov.serialization;

import java.io.Serializable;

/**
 * Created by sbt-nikiforov-mo on 10/3/16.
 */
public class Parent implements Serializable {
    private int version = 1;

    @Override
    public String toString() {
        return "Parent{" +
                "version=" + version +
                '}';
    }
}
