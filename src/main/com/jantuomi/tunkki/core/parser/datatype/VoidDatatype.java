package com.jantuomi.tunkki.core.parser.datatype;

import com.jantuomi.tunkki.exception.TunkkiError;

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
    public Datatype<Integer> add(Datatype<Integer> other) {
        return null;
    }

    @Override
    public Datatype<Integer> subtract(Datatype<Integer> other) {
        return null;
    }

    @Override
    public Datatype<Integer> multiply(Datatype<Integer> other) throws TunkkiError {
        return null;
    }

    @Override
    public Datatype<Integer> divide(Datatype<Integer> other) throws TunkkiError {
        return null;
    }
}
