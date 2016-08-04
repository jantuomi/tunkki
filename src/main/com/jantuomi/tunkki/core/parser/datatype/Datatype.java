package com.jantuomi.tunkki.core.parser.datatype;

import com.jantuomi.tunkki.exception.types.TunkkiError;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jan on 11.6.2016.
 */
abstract public class Datatype<T> {

    public enum Type {
        List,
        Integer,
        Double,
        String,
        Boolean,
        Nada,
        Void,
        Callable,
        Object
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

    abstract public Datatype<T> add(Datatype<T> other) throws TunkkiError;
    public abstract Datatype<T> subtract(Datatype<T> other) throws TunkkiError;
    public abstract Datatype<T> multiply(Datatype<T> other) throws TunkkiError;
    public abstract Datatype<T> divide(Datatype<T> other) throws TunkkiError;
    public abstract BooleanDatatype equals(Datatype<T> other) throws TunkkiError;

    public static String toString(List<Datatype> variables) {
        String result = "[";
        List<String> strings = variables.stream().map(Datatype::toString).collect(Collectors.toList());
        result += String.join(", ", strings);
        result += "]";
        return result;
    }
}
