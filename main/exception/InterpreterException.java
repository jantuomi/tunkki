package com.jantuomi.interpreter.main.exception;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by jan on 12.6.2016.
 */
public class InterpreterException {

    public enum Exception {
        IllegalTokenError,
        UnknownOperatorError,
        SyntaxError,
        TypeError
    }

    public static Map<Exception, String> errorTexts = new HashMap<>();

    static {
        errorTexts.put(Exception.IllegalTokenError, "Illegal token %s found.");
        errorTexts.put(Exception.UnknownOperatorError, "Unexpected operator %s found.");
        errorTexts.put(Exception.SyntaxError, "Unexpected %s.");
        errorTexts.put(Exception.TypeError, "Incompatible types %s and %s.");
    }

    private Exception exception;

    public InterpreterException(Exception e) {
        exception = e;
    }

    public String what() {
        return errorTexts.get(exception);
    }
}
