package com.jantuomi.tunkki.core.parser.datatype;

import com.jantuomi.tunkki.exception.types.TunkkiError;

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
    public Datatype add(Datatype other) throws TunkkiError {
        return null;
    }

    @Override
    public Datatype subtract(Datatype other) throws TunkkiError {
        return null;
    }

    @Override
    public Datatype multiply(Datatype other) throws TunkkiError {
        return null;
    }

    @Override
    public Datatype divide(Datatype other) throws TunkkiError {
        return null;
    }

    @Override
    public BooleanDatatype equals(Datatype other) throws TunkkiError {
        switch (other.getType()) {
            case Boolean:
                return new BooleanDatatype(getData().equals(other.getData()));
            case Nada:
                return new BooleanDatatype(false);
        }
        return null;
    }
}
