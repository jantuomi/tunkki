package com.jantuomi.interpreter.main.core.parser.datatype;


/**
 * Created by jan on 11.6.2016.
 */
abstract public class DataContainer<T> {
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private T data;
}
