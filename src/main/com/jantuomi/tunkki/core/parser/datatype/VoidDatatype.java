package com.jantuomi.tunkki.core.parser.datatype;

import com.jantuomi.tunkki.exception.types.TunkkiError;

/**
 * Created by jan on 17.6.2016.
 */
public class VoidDatatype extends Datatype<Integer> {

    @Override
    public Type getType() {
        return Type.Void;
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public Datatype add(Datatype other) {
        return null;
    }

    @Override
    public Datatype subtract(Datatype other) {
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
        return new BooleanDatatype(false);
    }
}
