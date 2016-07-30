package com.jantuomi.tunkki.core.parser.datatype;

import com.jantuomi.tunkki.exception.TunkkiError;

/**
 * Created by jan on 16.6.2016.
 */
public class StringDatatype extends Datatype<String> {


    public StringDatatype(String text) {
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
    public Datatype<String> add(Datatype<String> other) {
        return new StringDatatype(
                getData() + other.getData()
        );
    }

    @Override
    public Datatype<String> subtract(Datatype<String> other) throws TunkkiError {
        return null;
    }

    @Override
    public Datatype<String> multiply(Datatype<String> other) throws TunkkiError {
        return null;
    }

    @Override
    public Datatype<String> divide(Datatype<String> other) throws TunkkiError {
        return null;
    }

    @Override
    public BooleanDatatype equals(Datatype<String> other) throws TunkkiError {
        switch (other.getType()) {
            case String:
                return new BooleanDatatype(getData().equals(other.getData()));
            case Nada:
                return new BooleanDatatype(false);
        }
        return null;
    }
}
