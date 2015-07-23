package com.mnikiforov.advanced_java.multi_thread.transfer;

import com.mnikiforov.advanced_java.multi_thread.Operations;
import com.mnikiforov.advanced_java.multi_thread.TransferInfo;
import com.mnikiforov.advanced_java.multi_thread.exceptions.InsufficientFundsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by SBT-Nikiforov-MO on 29.06.2015.
 */
public class TransferWithLockTimeout implements Transfer {

    private static final Logger log = LoggerFactory.getLogger(TransferWithLockTimeout.class);
    private static final long SLEEP_TIMEOUT = 1500;
    private static final long LOCK_TIMEOUT = SLEEP_TIMEOUT * Operations.POOL_SIZE;

    @Override
    public TransferInfo transfer(TransferInfo transferInfo) throws InsufficientFundsException, InterruptedException {
        long startTime = System.nanoTime();

        if (transferInfo.getAcc1().getBalance() < transferInfo.getAmount()) {
            throw new InsufficientFundsException();
        }

        while (!transferInfo.isSucces()/* && transferInfo.getFailCount() <= 5*/) {
            if (transferInfo.getAcc1().getLock().tryLock(LOCK_TIMEOUT, TimeUnit.MILLISECONDS)) {
                log.trace("procId: {}; lock '{}'", transferInfo.getId(), transferInfo.getAcc1().getName());
                try {
                    if (transferInfo.getAcc2().getLock().tryLock(LOCK_TIMEOUT, TimeUnit.MILLISECONDS)) {
                        log.trace("procId: {}; lock '{}'", transferInfo.getId(), transferInfo.getAcc2().getName());
                        try {
                            Thread.sleep(SLEEP_TIMEOUT);
                            transferInfo.getAcc1().withdraw(transferInfo.getAmount());
                            transferInfo.getAcc2().deposite(transferInfo.getAmount());
                            log.info("procId: {} succesfully finished!!! amount {} withdraw '{}' and deposite in '{}'",
                                    transferInfo.getId(), transferInfo.getAmount(), transferInfo.getAcc1().getName(), transferInfo.getAcc2().getName());
                            transferInfo.setSucces(true);
                            transferInfo.addTotalTime(System.nanoTime() - startTime);
                        } finally {
                            transferInfo.getAcc2().getLock().unlock();
                            log.trace("procId: {}; unlock '{}'", transferInfo.getId(), transferInfo.getAcc2().getName());
                        }
                    } else {
                        transferInfo.getAcc2().getFailLockCount().incrementAndGet();
                        transferInfo.setSucces(false);
                        transferInfo.incrementFailCount();
                        transferInfo.addTotalTime(System.nanoTime() - startTime);
                        log.warn("procId: {}; can not lock '{}'", transferInfo.getId(), transferInfo.getAcc2().getName());
                    }
                } finally {
                    transferInfo.getAcc1().getLock().unlock();
                    log.trace("procId: {}; unlock '{}'", transferInfo.getId(), transferInfo.getAcc1().getName());
                }
            } else {
                transferInfo.getAcc1().getFailLockCount().incrementAndGet();
                transferInfo.setSucces(false);
                transferInfo.incrementFailCount();
                transferInfo.addTotalTime(System.nanoTime() - startTime);
                log.warn("procId: {}; can not lock '{}'", transferInfo.getId(), transferInfo.getAcc1().getName());
            }
        }
        return transferInfo;
    }
}
