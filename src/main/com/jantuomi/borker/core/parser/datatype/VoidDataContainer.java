package com.jantuomi.borker.core.parser.datatype;

import com.jantuomi.borker.exception.InterpreterException;

/**
 * Created by jan on 17.6.2016.
 */
public class VoidDataContainer extends DataContainer<Integer> {

    @Override
    public Type getType() {
        return Type.Void;
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public DataContainer<Integer> add(DataContainer<Integer> other) {
        return null;
    }

    @Override
    public DataContainer<Integer> subtract(DataContainer<Integer> other) {
        return null;
    }

    @Override
    public DataContainer<Integer> multiply(DataContainer<Integer> other) throws InterpreterException {
        return null;
    }

    @Override
    public DataContainer<Integer> divide(DataContainer<Integer> other) throws InterpreterException {
        return null;
    }
}
