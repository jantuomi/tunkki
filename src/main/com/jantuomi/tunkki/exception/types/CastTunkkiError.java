package com.jantuomi.tunkki.exception.types;

/**
 * Created by jan on 2.8.2016.
 */
public class CastTunkkiError extends TunkkiError {
    public CastTunkkiError(int line, String... args) {
        super(line, args);
    }

    @Override
    public String what() {
        return "Illegal cast to type %s from value %s.";
    }

    @Override
    ExceptionType getType() {
        return ExceptionType.CastError;
    }
}
