package com.jantuomi.borker.core.parser.datatype;

import com.jantuomi.borker.exception.BorkError;

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
        return getData();
    }

    @Override
    public DataContainer<String> add(DataContainer<String> other) {
        return new StringDataContainer(
                getData() + other.getData()
        );
    }

    @Override
    public DataContainer<String> subtract(DataContainer<String> other) throws BorkError {
        return null;
    }

    @Override
    public DataContainer<String> multiply(DataContainer<String> other) throws BorkError {
        return null;
    }

    @Override
    public DataContainer<String> divide(DataContainer<String> other) throws BorkError {
        return null;
    }
}
