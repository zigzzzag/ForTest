package com.mnikiforov.multithreading.non_synch;

/**
 * Исполняемый поток, в котором деньги переводятся с одного банковского счета на другой
 * <p>
 * Created by zigzzzag on 28.07.16.
 */
public class TransferRunnable implements Runnable {

    private Bank bank;
    private int fromAcccount;
    private double maxAccount;
    private int DELAY = 10;

    /**
     * Конструирует объект исполняемого потока
     *
     * @param b    Банк, где деньги переводятся с одного счета на другой
     * @param from Счет, с которого переводятся деньги
     * @param max  Максимальная сумма перевода в каждой транзакции
     */
    public TransferRunnable(Bank b, int from, double max) {
        bank = b;
        fromAcccount = from;
        maxAccount = max;
    }

    @Override
    public void run() {
        while (true) {
            int toAccount = (int) (bank.size() * Math.random());
            double amount = maxAccount * Math.random();
            bank.transfer(fromAcccount, toAccount, amount);
            try {
                Thread.sleep((long) (DELAY * Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
