package com.jantuomi.tunkki.core.parser.datatype;

import com.jantuomi.tunkki.exception.TunkkiError;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jan on 11.6.2016.
 */
abstract public class DataContainer<T> {

    public enum Type {
        List,
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

    abstract public DataContainer<T> add(DataContainer<T> other) throws TunkkiError;
    public abstract DataContainer<T> subtract(DataContainer<T> other) throws TunkkiError;
    public abstract DataContainer<T> multiply(DataContainer<T> other) throws TunkkiError;
    public abstract DataContainer<T> divide(DataContainer<T> other) throws TunkkiError;

    public static String toString(List<DataContainer> variables) {
        String result = "[";
        List<String> strings = variables.stream().map(DataContainer::toString).collect(Collectors.toList());
        result += String.join(", ", strings);
        result += "]";
        return result;
    }
}
