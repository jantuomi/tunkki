package com.jantuomi.tunkki.exception;

import com.jantuomi.tunkki.exception.types.TunkkiError;

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
}
