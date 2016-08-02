package com.jantuomi.tunkki.exception.types;

/**
 * Created by jan on 2.8.2016.
 */
public class IncludeTunkkiError extends TunkkiError {
    public IncludeTunkkiError(int line, String... args) {
        super(line, args);
    }

    @Override
    public String what() {
        return "File or module %s could not be included.";
    }

    @Override
    ExceptionType getType() {
        return ExceptionType.IncludeError;
    }
}
