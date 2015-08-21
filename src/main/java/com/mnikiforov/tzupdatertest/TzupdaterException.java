package com.mnikiforov.tzupdatertest;

/**
 * Created by SBT-Nikiforov-MO on 21.08.2015.
 */

public class TzupdaterException extends RuntimeException {
    private static final long serialVersionUID = -2678925365391997369L;

    public TzupdaterException() {
    }

    public TzupdaterException(String paramString) {
        super(paramString);
    }

    public TzupdaterException(String paramString, Throwable paramThrowable) {
        super(paramString, paramThrowable);
    }

    public TzupdaterException(Throwable paramThrowable) {
        super(paramThrowable);
    }
}
