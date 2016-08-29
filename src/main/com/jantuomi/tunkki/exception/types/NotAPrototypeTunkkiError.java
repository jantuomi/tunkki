package com.jantuomi.tunkki.exception.types;

/**
 * Created by jan on 29.8.2016.
 */
public class NotAPrototypeTunkkiError extends TunkkiError {
    public NotAPrototypeTunkkiError(int line, String... args) {
        super(line, args);
    }

    @Override
    public String what() {
        return "Symbol %s is not an object prototype.";
    }

    @Override
    ExceptionType getType() {
        return ExceptionType.NotAPrototypeError;
    }
}
