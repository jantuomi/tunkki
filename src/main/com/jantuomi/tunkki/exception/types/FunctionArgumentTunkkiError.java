package com.jantuomi.tunkki.exception.types;

/**
 * Created by jan on 2.8.2016.
 */
public class FunctionArgumentTunkkiError extends TunkkiError {
    public FunctionArgumentTunkkiError(int line, String... args) {
        super(line, args);
    }

    @Override
    public String what() {
        return "The parameter list given to function %s is either of wrong length or the parameters are of wrong type. Actual: %s";
    }

    @Override
    ExceptionType getType() {
        return ExceptionType.FunctionArgumentError;
    }
}
