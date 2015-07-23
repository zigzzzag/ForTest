package com.mnikiforov.advanced_java.multi_thread.transfer;

import com.mnikiforov.advanced_java.multi_thread.Account;
import com.mnikiforov.advanced_java.multi_thread.TransferInfo;
import com.mnikiforov.advanced_java.multi_thread.exceptions.InsufficientFundsException;

/**
 * Created by SBT-Nikiforov-MO on 29.06.2015.
 */
public class TransferSimple implements Transfer {

    @Override
    public TransferInfo transfer(TransferInfo transferInfo) throws InsufficientFundsException, InterruptedException {
        if (transferInfo.getAcc1().getBalance() < transferInfo.getAmount()) {
            throw new InsufficientFundsException();
        }

        transferInfo.getAcc1().withdraw(transferInfo.getAmount());
        transferInfo.getAcc2().deposite(transferInfo.getAmount());

        transferInfo.setSucces(true);
        return transferInfo;
    }
}
