package com.jantuomi.tunkki.exception.types;

/**
 * Created by jan on 8.8.2016.
 */
public class MissingTerminatorTokenTunkkiError extends TunkkiError {
    public MissingTerminatorTokenTunkkiError(int line, String... args) {
        super(line, args);
    }

    @Override
    public String what() {
        return "Expected terminator token for token %s.";
    }

    @Override
    ExceptionType getType() {
        return ExceptionType.MissingTerminatorTokenError;
    }
}
