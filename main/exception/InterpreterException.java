package com.jantuomi.interpreter.main.exception;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by jan on 12.6.2016.
 */
public class InterpreterException {

    public enum Exception {
        IllegalTokenException,
        UnknownOperatorException
    }

    public static Map<Exception, String> errorTexts = new HashMap<>();

    static {
        errorTexts.put(Exception.IllegalTokenException, "Illegal token %s found.");
        errorTexts.put(Exception.UnknownOperatorException, "Unknown operator %s found.");
    }

    private Exception exception;

    public InterpreterException(Exception e) {
        exception = e;
    }

    public String what() {
        return errorTexts.get(exception);
    }
}
