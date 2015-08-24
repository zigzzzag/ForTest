package com.mnikiforov.tzupdatertest;

public class TzRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 9055589896614548374L;

    public TzRuntimeException() {
    }

    public TzRuntimeException(String paramString) {
        super(paramString);
    }

    public TzRuntimeException(String paramString, Throwable paramThrowable) {
        super(paramString, paramThrowable);
    }

    public TzRuntimeException(Throwable paramThrowable) {
        super(paramThrowable);
    }
}

