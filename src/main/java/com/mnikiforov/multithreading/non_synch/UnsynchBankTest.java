package com.mnikiforov.multithreading.non_synch;

/**
 * В этой программе демонстрируется нарушение данных при произвольном доступе к структуре данных из многих потоков
 * <p>
 * Created by zigzzzag on 28.07.16.
 */
public class UnsynchBankTest {

    public static final int NACCOUNTS = 100;
    public static final double INITIAL_BALANCE = 1000;

    public static void main(String[] args) {
        Bank b = new Bank(NACCOUNTS, INITIAL_BALANCE);
        for (int i = 0; i < NACCOUNTS; i++) {
            TransferRunnable r = new TransferRunnable(b, i, INITIAL_BALANCE);
            Thread t = new Thread(r);
            t.start();
        }
    }
}
