package com.jantuomi.tunkki.exception.types;

/**
 * Created by jan on 3.8.2016.
 */
public class FileNotFoundTunkkiError extends TunkkiError {
    public FileNotFoundTunkkiError(int line, String... args) {
        super(line, args);
    }

    @Override
    public String what() {
        return "File %s could not be found.";
    }

    @Override
    ExceptionType getType() {
        return ExceptionType.FileNotFoundError;
    }
}
