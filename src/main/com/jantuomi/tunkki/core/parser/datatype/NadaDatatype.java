package com.jantuomi.tunkki.core.parser.datatype;

import com.jantuomi.tunkki.exception.types.NadaTunkkiError;
import com.jantuomi.tunkki.exception.types.TunkkiError;

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
    public Datatype add(Datatype other) throws TunkkiError {
        doOperation();
        return null;
    }

    @Override
    public Datatype subtract(Datatype other) throws TunkkiError {
        doOperation();
        return null;
    }

    @Override
    public Datatype multiply(Datatype other) throws TunkkiError {
        doOperation();
        return null;
    }

    @Override
    public Datatype divide(Datatype other) throws TunkkiError {
        doOperation();
        return null;
    }

    @Override
    public BooleanDatatype equals(Datatype other) throws TunkkiError {
        if (other.getType() == Type.Nada) {
            return new BooleanDatatype(true);
        }
        return new BooleanDatatype(false);
    }

    private void doOperation() throws TunkkiError {
        throw new NadaTunkkiError(-1);
    }
}
