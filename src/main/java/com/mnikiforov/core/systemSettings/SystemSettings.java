package com.mnikiforov.core.systemSettings;

/**
 * Created by zigzzzag on 19.10.2015.
 */
public class SystemSettings {

    private static final long MByte = 1024 * 1024;

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        System.out.println("runtime.freeMemory() = " + runtime.freeMemory() / MByte + "MB");

        System.out.println("runtime.maxMemory() = " + runtime.maxMemory() / MByte + "MB");

        System.out.println("runtime.totalMemory() = " + runtime.totalMemory() / MByte + "MB");

        System.out.println("runtime.availableProcessors() = " + runtime.availableProcessors());
    }
}
