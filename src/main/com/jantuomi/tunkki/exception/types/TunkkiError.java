package com.jantuomi.tunkki.exception.types;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jan on 12.6.2016.
 */
abstract public class TunkkiError extends Exception {

    public enum ExceptionType {
        IllegalTokenError,
        SyntaxError,
        TypeError,
        FunctionArgumentError,
        ExpectedDifferentTokenError,
        UndeclaredSymbolError,
        IncludeError,
        GeneralError,
        CastError,
        DivisionByZeroError,
        RecursiveIncludeError,
        OutOfBoundsError,
        FileNotFoundError,
        NotAnObjectError,
        MissingTerminatorTokenError,
        NadaError,
        NotAPrototypeError
    }

    private int line;
    private String[] args;

    public TunkkiError(int line, String... args) {
        super();
        this.line = line;
        this.args = args;
    }

    private static String formatMessage(String message, int line, String... parameters) {

        message = String.format(message, parameters);
        if (line == -1) {
            return "\n" + message;
        } else {
            return String.format("\nLine #%d: ", line) + message;
        }
    }

    abstract public String what();

    abstract ExceptionType getType();

    public void setLine(int line) {
        this.line = line;
    }

    protected String completeMessage() {
        return formatMessage(getType().toString() + ": " + what(), line, args);
    }

    @Override
    public void printStackTrace() {
        System.err.println(completeMessage());
    }
}
