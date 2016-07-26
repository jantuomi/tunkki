package com.jantuomi.tunkki.exception;

/**
 * Created by jan on 10.6.2016.
 */
public class ExceptionManager {

    private static final ExceptionManager instance = new ExceptionManager();

    private ExceptionManager() {
    }

    public static ExceptionManager getInstance() {
        return instance;
    }

    public static void raise(TunkkiError.ExceptionType ex, int line, String... args) throws TunkkiError {
        TunkkiError e = new TunkkiError(ex, line, args);
        throw e;
    }
}
