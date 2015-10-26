package com.mnikiforov.advanced_java.Golovach.multi_thread.countdownlatch;

/**
 * Created by SBT-Nikiforov-MO on 01.07.2015.
 */
public class CDLApp {

    public static void main(String[] args) throws InterruptedException, java.io.IOException {
        System.err.println("Prepping...");

        Race r = new Race(
                "Beverly",
                "RockerHorse",
                "Phineas",
                "Ferb",
                "Tin Cup",
                "Monkey",
                "Glue"
        );

        System.err.println("It's a race of " + r.getDistance() + " lengths");

        System.err.println("Press Enter to run the race....");
        System.in.read();

        r.run();
    }
}