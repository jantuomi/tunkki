package com.jantuomi.tunkki.exception.types;

/**
 * Created by jan on 2.8.2016.
 */
public class SyntaxTunkkiError extends TunkkiError {
    public SyntaxTunkkiError(int line, String... args) {
        super(line, args);
    }

    @Override
    public String what() {
        return "Unexpected %s.";
    }

    @Override
    ExceptionType getType() {
        return ExceptionType.SyntaxError;
    }
}
