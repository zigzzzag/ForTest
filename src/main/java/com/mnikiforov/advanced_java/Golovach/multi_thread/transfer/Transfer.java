package com.mnikiforov.advanced_java.Golovach.multi_thread.transfer;

import com.mnikiforov.advanced_java.Golovach.multi_thread.TransferInfo;
import com.mnikiforov.advanced_java.Golovach.multi_thread.exceptions.InsufficientFundsException;

/**
 * Created by SBT-Nikiforov-MO on 29.06.2015.
 */
public interface Transfer {

    TransferInfo transfer(TransferInfo transferInfo) throws InsufficientFundsException, InterruptedException;
}
