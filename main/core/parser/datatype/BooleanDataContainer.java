package com.jantuomi.interpreter.main.core.parser.datatype;

import com.jantuomi.interpreter.main.exception.ExceptionManager;
import com.jantuomi.interpreter.main.exception.InterpreterException;

/**
 * Created by jan on 16.6.2016.
 */
public class BooleanDataContainer extends DataContainer<Boolean> {


    public BooleanDataContainer(boolean value) {
        setData(value);
    }

    @Override
    public String toString() {
        return Boolean.toString(getData());
    }

    @Override
    public DataContainer<Boolean> add(DataContainer<Boolean> other) throws InterpreterException {
        ExceptionManager.raise(InterpreterException.ExceptionType.TypeError, -1, "boolean", "boolean");
        return null;
    }

    @Override
    public DataContainer<Boolean> subtract(DataContainer<Boolean> other) throws InterpreterException {
        ExceptionManager.raise(InterpreterException.ExceptionType.TypeError, -1, "boolean", "boolean");
        return null;
    }
}
