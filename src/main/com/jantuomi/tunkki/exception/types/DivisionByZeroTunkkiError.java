package com.jantuomi.tunkki.exception.types;

/**
 * Created by jan on 2.8.2016.
 */
public class DivisionByZeroTunkkiError extends TunkkiError {
    public DivisionByZeroTunkkiError(int line, String... args) {
        super(line, args);
    }

    @Override
    public String what() {
        return "Division by zero.";
    }

    @Override
    public ExceptionType getType() {
        return ExceptionType.DivisionByZeroError;
    }
}
