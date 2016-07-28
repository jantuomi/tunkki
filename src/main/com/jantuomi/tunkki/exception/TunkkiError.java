package com.jantuomi.tunkki.exception;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jan on 12.6.2016.
 */
public class TunkkiError extends Exception {

    public enum ExceptionType {
        IllegalTokenError,
        SyntaxError,
        TypeError,
        FunctionArgumentError,
        ExpectedTokenError,
        UndeclaredSymbolError,
        IncludeError,
        GeneralError
    }

    private static Map<ExceptionType, String> errorTexts = new HashMap<>();

    static {
        errorTexts.put(ExceptionType.IllegalTokenError, "Unknown or illegal token %s found.");
        errorTexts.put(ExceptionType.SyntaxError, "Unexpected %s.");
        errorTexts.put(ExceptionType.TypeError, "Incompatible types %s and %s.");
        errorTexts.put(ExceptionType.ExpectedTokenError, "Token '%s' expects a different token stack.");
        errorTexts.put(ExceptionType.FunctionArgumentError, "The parameter list given to function %s is either of wrong length or the parameters are of wrong type. Actual: %s");
        errorTexts.put(ExceptionType.UndeclaredSymbolError, "No symbol %s defined, parameters: [%s].");
        errorTexts.put(ExceptionType.IncludeError, "File %s could not be included.");
        errorTexts.put(ExceptionType.GeneralError, "%s");
    }

    private ExceptionType exceptionType;
    private String completeMessage;
    private List<String> arguments;

    public TunkkiError(ExceptionType exceptionType, int line, String... args) {
        super(exceptionType.toString(), null, false, false);
        this.exceptionType = exceptionType;
        this.arguments = Arrays.asList(args);
        this.completeMessage = formatMessage(exceptionType.toString() + ": " + what(exceptionType), line, args);
    }

    private static String formatMessage(String message, int line, String... parameters) {

        message = String.format(message, parameters);
        if (line == -1) {
            return "\n" + message;
        } else {
            return String.format("\nline %d: ", line) + message;
        }
    }

    public static String what(ExceptionType type) {
        return errorTexts.get(type);
    }

    @Override
    public void printStackTrace() {
        System.err.println(completeMessage);
    }

    public ExceptionType getType() {
        return exceptionType;
    }

    public List<String> getArguments() {
        return this.arguments;
    }
}
