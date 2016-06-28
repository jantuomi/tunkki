package com.jantuomi.borker.core.parser.datatype;

import com.jantuomi.borker.exception.InterpreterException;

/**
 * Created by jan on 16.6.2016.
 */
public class BooleanDataContainer extends DataContainer<Boolean> {


    public BooleanDataContainer(boolean value) {
        setData(value);
    }

    @Override
    public Type getType() {
        return Type.Boolean;
    }

    @Override
    public String toString() {
        return Boolean.toString(getData());
    }

    @Override
    public DataContainer<Boolean> add(DataContainer<Boolean> other) throws InterpreterException {
        return null;
    }

    @Override
    public DataContainer<Boolean> subtract(DataContainer<Boolean> other) throws InterpreterException {
        return null;
    }

    @Override
    public DataContainer<Boolean> multiply(DataContainer<Boolean> other) throws InterpreterException {
        return null;
    }

    @Override
    public DataContainer<Boolean> divide(DataContainer<Boolean> other) throws InterpreterException {
        return null;
    }
}
