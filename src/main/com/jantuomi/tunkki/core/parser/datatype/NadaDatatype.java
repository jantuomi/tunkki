package com.jantuomi.tunkki.core.parser.datatype;

import com.jantuomi.tunkki.exception.TunkkiError;

/**
 * Created by jan on 29.7.2016.
 */
public class NadaDatatype extends Datatype<Integer> {
    @Override
    public Type getType() {
        return Type.Nada;
    }

    @Override
    public String toString() {
        return "nada";
    }

    @Override
    public Datatype<Integer> add(Datatype<Integer> other) throws TunkkiError {
        doOperation();
        return null;
    }

    @Override
    public Datatype<Integer> subtract(Datatype<Integer> other) throws TunkkiError {
        doOperation();
        return null;
    }

    @Override
    public Datatype<Integer> multiply(Datatype<Integer> other) throws TunkkiError {
        doOperation();
        return null;
    }

    @Override
    public Datatype<Integer> divide(Datatype<Integer> other) throws TunkkiError {
        doOperation();
        return null;
    }

    private void doOperation() throws TunkkiError {
        throw new TunkkiError(TunkkiError.ExceptionType.NadaError, -1);
    }
}
