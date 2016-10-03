package com.mnikiforov.serialization;

import java.io.Serializable;

/**
 * Created by sbt-nikiforov-mo on 10/3/16.
 */
public class SomeData implements Serializable {

    private String id = "Hello from some data!";

    @Override
    public String toString() {
        return "SomeData{" +
                "id='" + id + '\'' +
                '}';
    }
}
