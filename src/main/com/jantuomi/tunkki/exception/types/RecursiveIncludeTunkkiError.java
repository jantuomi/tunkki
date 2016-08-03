package com.jantuomi.tunkki.exception.types;

/**
 * Created by jan on 3.8.2016.
 */
public class RecursiveIncludeTunkkiError extends TunkkiError {
    public RecursiveIncludeTunkkiError(int line, String... args) {
        super(line, args);
    }

    @Override
    public String what() {
        return "Recursive include with module name '%s' detected.";
    }

    @Override
    ExceptionType getType() {
        return ExceptionType.RecursiveIncludeError;
    }
}
