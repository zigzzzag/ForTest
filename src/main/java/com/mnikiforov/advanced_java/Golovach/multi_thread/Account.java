package com.mnikiforov.advanced_java.Golovach.multi_thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zigzzzag on 22.06.2015.
 */
public class Account {

    private String name;
    private int balance;
    private AtomicInteger failLockCount = new AtomicInteger(0);
    private Lock lock = new ReentrantLock();

    public Account(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public void withdraw(int amount) {
        this.balance -= amount;
    }

    public void deposite(int amount) {
        this.balance += amount;
    }

    public int getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Lock getLock() {
        return lock;
    }

    public AtomicInteger getFailLockCount() {
        return failLockCount;
    }

    @Override
    public String toString() {
        return new StringBuilder("'").append(name).append("':").append(balance).toString();
    }
}
