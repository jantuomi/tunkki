package com.jantuomi.tunkki.core.parser.datatype;

import com.jantuomi.tunkki.exception.TunkkiError;

/**
 * Created by jan on 16.6.2016.
 */
public class StringDataContainer extends DataContainer<String> {


    public StringDataContainer(String text) {
        setData(text);
    }

    @Override
    public Type getType() {
        return Type.String;
    }

    @Override
    public String toString() {
        return String.format("\"%s\"", getData());
    }

    @Override
    public DataContainer<String> add(DataContainer<String> other) {
        return new StringDataContainer(
                getData() + other.getData()
        );
    }

    @Override
    public DataContainer<String> subtract(DataContainer<String> other) throws TunkkiError {
        return null;
    }

    @Override
    public DataContainer<String> multiply(DataContainer<String> other) throws TunkkiError {
        return null;
    }

    @Override
    public DataContainer<String> divide(DataContainer<String> other) throws TunkkiError {
        return null;
    }
}
