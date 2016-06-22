package com.jantuomi.interpreter.main.exception;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by jan on 12.6.2016.
 */
public class InterpreterException extends Exception {

    public enum ExceptionType {
        IllegalTokenError,
        UnknownOperatorError,
        SyntaxError,
        TypeError,
        ArgumentError,
        UndeclaredSymbolError
    }

    public static Map<ExceptionType, String> errorTexts = new HashMap<>();

    static {
        errorTexts.put(ExceptionType.IllegalTokenError, "Unknown or illegal token %s found.");
        errorTexts.put(ExceptionType.SyntaxError, "Unexpected %s.");
        errorTexts.put(ExceptionType.TypeError, "Incompatible types %s and %s.");
        errorTexts.put(ExceptionType.ArgumentError, "The parameter list given to function %s is either of wrong length or the parameters are of wrong type. Actual: %s");
        errorTexts.put(ExceptionType.UndeclaredSymbolError, "No symbol %s defined, parameters: [%s].");
    }

    private ExceptionType exceptionType;
    private String completeMessage;

    public InterpreterException(ExceptionType exceptionType, int line, String... args) {
        super(exceptionType.toString(), null, false, false);
        this.exceptionType = exceptionType;
        this.completeMessage = formatMessage(exceptionType.toString() + ": " + what(exceptionType), line, args);
    }

    private static String formatMessage(String message, int line, String... args) {

        message = String.format(message, args);
        return String.format("\nline %d: ", line) + message;
    }

    public static String what(ExceptionType type) {
        return errorTexts.get(type);
    }

    @Override
    public void printStackTrace() {
        System.err.println(completeMessage);
    }
}
