package com.mnikiforov.advanced_java.multi_thread;

import com.mnikiforov.advanced_java.multi_thread.exceptions.InsufficientFundsException;
import com.mnikiforov.advanced_java.multi_thread.transfer.Transfer;

/**
 * Created by SBT-Nikiforov-MO on 29.06.2015.
 */
public class OperationProc implements Runnable {

    private Transfer transfer;
    private TransferInfo transferInfo;

    public OperationProc(Transfer transfer, TransferInfo transferInfo) {
        this.transfer = transfer;
        this.transferInfo = transferInfo;
    }

    @Override
    public void run() {
        try {
            transfer.transfer(transferInfo);
        } catch (InsufficientFundsException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
