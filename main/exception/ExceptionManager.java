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

    public static void raise(InterpreterException.Exception ex, int line, List<String> args) {
        InterpreterException e = new InterpreterException(ex);
        String output = e.what();
        for (String arg : args) {
            output = String.format(output, arg);
        }
        System.err.println(String.format("[%s] line: %d %s", ex.toString(), line, output));
    }


}
