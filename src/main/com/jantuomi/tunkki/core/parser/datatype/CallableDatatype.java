package com.jantuomi.tunkki.core.parser.datatype;

import com.jantuomi.tunkki.core.runtime.Function;
import com.jantuomi.tunkki.exception.types.TunkkiError;

import java.util.List;

/**
 * Created by jan on 30.7.2016.
 */
public class CallableDatatype extends Datatype<Function> {

    @Override
    public Type getType() {
        return Type.Callable;
    }

    @Override
    public String toString() {
        return "Callable";
    }

    public Datatype call(List<Datatype> params) throws TunkkiError {
        return getData().evaluate(params);
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
            case Nada:
                return new BooleanDatatype(false);
        }
        return null;
    }
}
