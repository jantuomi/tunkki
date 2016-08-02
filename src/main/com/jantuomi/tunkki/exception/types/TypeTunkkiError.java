package com.jantuomi.tunkki.exception.types;

/**
 * Created by jan on 2.8.2016.
 */
public class TypeTunkkiError extends TunkkiError {
    public TypeTunkkiError(int line, String... args) {
        super(line, args);
    }

    @Override
    public String what() {
        return "Incompatible types %s and %s.";
    }

    @Override
    ExceptionType getType() {
        return ExceptionType.TypeError;
    }
}
