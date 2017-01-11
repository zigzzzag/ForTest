package com.mnikiforov.advanced_java.producer_consumer;

/**
 * Created by zigzzzag on 26.10.15.
 */
public class ProdConRunner {

    public static void main(String[] args) {
        Drop drop = new Drop();
        new Thread(new Producer(drop)).start();
        new Thread(new Consumer(drop)).start();
    }
}
