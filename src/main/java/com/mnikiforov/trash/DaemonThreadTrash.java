package com.mnikiforov.trash;

/**
 * Created by zigzzzag on 26.10.15.
 */
public class DaemonThreadTrash {

    public static void main(String[] args) {
        new Thread() {
            {
                this.setDaemon(true);
            }

            public void run() {
                while (true) {
                    System.out.println("Thread is running!");
                }
            }
        }.start();
    }
}
