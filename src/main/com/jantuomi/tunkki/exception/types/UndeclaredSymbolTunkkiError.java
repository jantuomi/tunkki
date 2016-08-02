package com.jantuomi.tunkki.exception.types;

/**
 * Created by jan on 2.8.2016.
 */
public class UndeclaredSymbolTunkkiError extends TunkkiError {
    public UndeclaredSymbolTunkkiError(int line, String... args) {
        super(line, args);
    }

    @Override
    public String what() {
        return "No symbol %s defined in the current scope.";
    }

    @Override
    ExceptionType getType() {
        return ExceptionType.UndeclaredSymbolError;
    }
}
