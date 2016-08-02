package com.jantuomi.tunkki.exception.types;

/**
 * Created by jan on 2.8.2016.
 */
public class IllegalTokenTunkkiError extends TunkkiError {
    public IllegalTokenTunkkiError(int line, String... args) {
        super(line, args);
    }

    @Override
    public String what() {
        return "Unknown or illegal token %s found.";
    }

    @Override
    ExceptionType getType() {
        return ExceptionType.IllegalTokenError;
    }
}
