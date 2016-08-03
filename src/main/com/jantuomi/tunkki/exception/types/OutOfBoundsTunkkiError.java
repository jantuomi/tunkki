package com.jantuomi.tunkki.exception.types;

/**
 * Created by jan on 3.8.2016.
 */
public class OutOfBoundsTunkkiError extends TunkkiError {
    public OutOfBoundsTunkkiError(int line, String... args) {
        super(line, args);
    }

    @Override
    public String what() {
        return "Index %s is out of bounds.";
    }

    @Override
    ExceptionType getType() {
        return ExceptionType.OutOfBoundsError;
    }
}
