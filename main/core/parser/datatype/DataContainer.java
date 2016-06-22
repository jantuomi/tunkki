package com.jantuomi.interpreter.main.core.parser.datatype;

import com.jantuomi.interpreter.main.exception.InterpreterException;

/**
 * Created by jan on 11.6.2016.
 */
abstract public class DataContainer<T> {

    public enum Type {
        Integer,
        Double,
        String,
        Boolean,
        Void
    }

    abstract public Type getType();

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    abstract public String toString();

    abstract public DataContainer<T> add(DataContainer<T> other) throws InterpreterException;
    public abstract DataContainer<T> subtract(DataContainer<T> other) throws InterpreterException;
    public abstract DataContainer<T> multiply(DataContainer<T> other) throws InterpreterException;
    public abstract DataContainer<T> divide(DataContainer<T> other) throws InterpreterException;
}
