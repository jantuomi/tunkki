package com.jantuomi.tunkki.core.parser.datatype;

import com.jantuomi.tunkki.exception.TunkkiError;

/**
 * Created by jan on 16.6.2016.
 */
public class BooleanDatatype extends Datatype<Boolean> {


    public BooleanDatatype(boolean value) {
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
    public Datatype<Boolean> add(Datatype<Boolean> other) throws TunkkiError {
        return null;
    }

    @Override
    public Datatype<Boolean> subtract(Datatype<Boolean> other) throws TunkkiError {
        return null;
    }

    @Override
    public Datatype<Boolean> multiply(Datatype<Boolean> other) throws TunkkiError {
        return null;
    }

    @Override
    public Datatype<Boolean> divide(Datatype<Boolean> other) throws TunkkiError {
        return null;
    }

    @Override
    public BooleanDatatype equals(Datatype<Boolean> other) throws TunkkiError {
        switch (other.getType()) {
            case Boolean:
                return new BooleanDatatype(getData().equals(other.getData()));
            case Nada:
                return new BooleanDatatype(false);
        }
        return null;
    }
}
