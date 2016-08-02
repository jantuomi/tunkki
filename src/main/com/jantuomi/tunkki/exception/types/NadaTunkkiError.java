package com.jantuomi.tunkki.exception.types;

/**
 * Created by jan on 2.8.2016.
 */
public class NadaTunkkiError extends TunkkiError {
    public NadaTunkkiError(int line, String... args) {
        super(line, args);
    }

    @Override
    public String what() {
        return "Can't do operation with a nada value.";
    }

    @Override
    public ExceptionType getType() {
        return ExceptionType.NadaError;
    }
}
