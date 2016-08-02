package com.jantuomi.tunkki.exception.types;

/**
 * Created by jan on 2.8.2016.
 */
public class ExpectedDifferentTokenTunkkiError extends TunkkiError {
    public ExpectedDifferentTokenTunkkiError(int line, String... args) {
        super(line, args);
    }

    @Override
    public String what() {
        return "Token '%s' expects a different token stack.";
    }

    @Override
    ExceptionType getType() {
        return ExceptionType.ExpectedDifferentTokenError;
    }
}
