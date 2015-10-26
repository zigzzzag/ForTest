package com.mnikiforov.advanced_java.Golovach.multi_thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by SBT-Nikiforov-MO on 01.07.2015.
 */
public class TransferInfo {

    private static volatile AtomicInteger countObjects = new AtomicInteger(0);
    private final int id;
    private Account acc1;
    private Account acc2;
    private int amount;
    private boolean succes;
    private long totalTime = 0;
    private int failCount = 0;

    public TransferInfo() {
        this.id = countObjects.incrementAndGet();
    }

    public TransferInfo acc1(Account acc) {
        this.acc1 = acc;
        return this;
    }

    public TransferInfo acc2(Account acc) {
        this.acc2 = acc;
        return this;
    }

    public TransferInfo amount(int amount) {
        this.amount = amount;
        return this;
    }

    public int getId() {
        return id;
    }

    public Account getAcc1() {
        return acc1;
    }

    public void setAcc1(Account acc1) {
        this.acc1 = acc1;
    }

    public Account getAcc2() {
        return acc2;
    }

    public void setAcc2(Account acc2) {
        this.acc2 = acc2;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isSucces() {
        return succes;
    }

    public void setSucces(boolean succes) {
        this.succes = succes;
    }

    public long getTotalTimeMillis() {
        return totalTime / 1_000_000;
    }

    public long getTotalTimeNano() {
        return totalTime;
    }

    public void setTotalTime(long totalTime) {
        this.totalTime = totalTime;
    }

    public void addTotalTime(long totalTime) {
        this.totalTime += totalTime;
    }

    public void incrementFailCount() {
        this.failCount++;
    }

    public int getFailCount() {
        return failCount;
    }
}
