package com.jantuomi.interpreter.main.exception;

import java.util.List;

/**
 * Created by jan on 10.6.2016.
 */
public class ExceptionManager {

    private static final ExceptionManager instance = new ExceptionManager();

    private ExceptionManager() {
    }

    public static ExceptionManager getInstance() {
        return instance;
    }

    public static void raise(InterpreterException.ExceptionType ex, int line, List<String> args) throws InterpreterException {
        InterpreterException e = new InterpreterException(ex, line, args);
        throw e;
    }


}
