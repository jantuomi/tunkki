package com.jantuomi.tunkki.exception.types;

/**
 * Created by jan on 2.8.2016.
 */
public class GeneralTunkkiError extends TunkkiError {
    public GeneralTunkkiError(int line, String... args) {
        super(line, args);
    }

    @Override
    public String what() {
        return "%s";
    }

    @Override
    ExceptionType getType() {
        return ExceptionType.GeneralError;
    }
}
