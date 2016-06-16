package com.jantuomi.interpreter.main.exception;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jan on 12.6.2016.
 */
public class InterpreterException extends Exception {

    public enum ExceptionType {
        IllegalTokenError,
        UnknownOperatorError,
        SyntaxError,
        TypeError
    }

    public static Map<ExceptionType, String> errorTexts = new HashMap<>();

    static {
        errorTexts.put(ExceptionType.IllegalTokenError, "Illegal token %s found.");
        errorTexts.put(ExceptionType.UnknownOperatorError, "Unexpected operator %s found.");
        errorTexts.put(ExceptionType.SyntaxError, "Unexpected %s.");
        errorTexts.put(ExceptionType.TypeError, "Incompatible types %s and %s.");
    }

    private ExceptionType exceptionType;

    public InterpreterException(ExceptionType exceptionType, int line, List<String> args) {
        super(formatMessage(exceptionType.toString() + what(exceptionType), line, args));
        this.exceptionType = exceptionType;
    }

    private static String formatMessage(String message, int line, List<String> args) {
        for (String arg : args) {
            message = String.format(message, arg);
        }
        return String.format("line %d: ", line) + message;
    }

    public static String what(ExceptionType type) {
        return errorTexts.get(type);
    }
}
