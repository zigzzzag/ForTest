package com.mnikiforov.exceptions.sample;

/**
 * Created by SBT-Nikiforov-MO on 24.09.2015.
 */
public class SampleException extends Exception {

    private String message;

    public SampleException() {
    }

    public SampleException(String message) {
        super(message);
        this.message = message;
    }

    public String getMassage() {
        return message;
    }
}
