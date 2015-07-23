package com.mnikiforov.advanced_java.multi_thread.transfer;

import com.mnikiforov.advanced_java.multi_thread.TransferInfo;
import com.mnikiforov.advanced_java.multi_thread.exceptions.InsufficientFundsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by SBT-Nikiforov-MO on 29.06.2015.
 */
public class TransferDeadlock implements Transfer {

    private static final Logger log = LoggerFactory.getLogger(TransferDeadlock.class);

    @Override
    public TransferInfo transfer(TransferInfo transferInfo) throws InsufficientFundsException, InterruptedException {
        if (transferInfo.getAcc1().getBalance() < transferInfo.getAmount()) {
            throw new InsufficientFundsException();
        }

        synchronized (transferInfo.getAcc1()) {
            log.debug("procId: {}; synchronized '{}'!", transferInfo.getId(), transferInfo.getAcc1().getName());
            Thread.sleep(1000);
            synchronized (transferInfo.getAcc2()) {
                log.debug("procId: {}; synchronized '{}'!", transferInfo.getId(), transferInfo.getAcc2().getName());
                transferInfo.getAcc1().withdraw(transferInfo.getAmount());
                transferInfo.getAcc2().deposite(transferInfo.getAmount());

                transferInfo.setSucces(true);
                return transferInfo;
            }
        }
    }
}
