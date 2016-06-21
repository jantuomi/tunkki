package com.jantuomi.interpreter.main.core.parser.datatype;

import com.jantuomi.interpreter.main.exception.ExceptionManager;
import com.jantuomi.interpreter.main.exception.InterpreterException;

/**
 * Created by jan on 16.6.2016.
 */
public class StringDataContainer extends DataContainer<String> {


    public StringDataContainer(String text) {
        setData(text);
    }

    @Override
    public String toString() {
        return getData();
    }

    @Override
    public DataContainer<String> add(DataContainer<String> other) {
        return new StringDataContainer(
                getData() + other.getData()
        );
    }

    @Override
    public DataContainer<String> subtract(DataContainer<String> other) throws InterpreterException {
        ExceptionManager.raise(InterpreterException.ExceptionType.TypeError, -1, "string", "string");
        return null;
    }
}
