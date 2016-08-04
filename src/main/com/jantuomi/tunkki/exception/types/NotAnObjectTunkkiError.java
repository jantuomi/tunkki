package com.jantuomi.tunkki.exception.types;

/**
 * Created by jan on 4.8.2016.
 */
public class NotAnObjectTunkkiError extends TunkkiError {
    public NotAnObjectTunkkiError(int line, String... args) {
        super(line, args);
    }

    @Override
    public String what() {
        return "Symbol %s is not an object.";
    }

    @Override
    ExceptionType getType() {
        return ExceptionType.NotAnObjectError;
    }
}
