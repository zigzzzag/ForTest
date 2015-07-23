package com.mnikiforov.advanced_java.multi_thread.transfer;

import com.mnikiforov.advanced_java.multi_thread.TransferInfo;
import com.mnikiforov.advanced_java.multi_thread.exceptions.InsufficientFundsException;

/**
 * Created by SBT-Nikiforov-MO on 29.06.2015.
 */
public class TransferWithLock implements Transfer {

    @Override
    public TransferInfo transfer(TransferInfo transferInfo) throws InsufficientFundsException, InterruptedException {
        if (transferInfo.getAcc1().getBalance() < transferInfo.getAmount()) {
            throw new InsufficientFundsException();
        }

        transferInfo.getAcc1().getLock().lock();
        try {
            Thread.sleep(1000);
            transferInfo.getAcc2().getLock().lock();
            try {
                transferInfo.getAcc1().withdraw(transferInfo.getAmount());
                transferInfo.getAcc2().deposite(transferInfo.getAmount());

                transferInfo.setSucces(true);
            } finally {
                transferInfo.getAcc2().getLock().unlock();
            }
        } finally {
            transferInfo.getAcc1().getLock().unlock();
        }
        return transferInfo;
    }
}
