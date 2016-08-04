package com.jantuomi.tunkki.core.parser.datatype;

import com.jantuomi.tunkki.core.runtime.Scope;
import com.jantuomi.tunkki.exception.types.TunkkiError;

/**
 * Created by jan on 4.8.2016.
 */
public class ObjectDatatype extends Datatype<Scope> {
    public ObjectDatatype() {
        setData(new Scope());
    }

    @Override
    public Type getType() {
        return Type.Object;
    }

    @Override
    public String toString() {
        String sb = "Object [";
        sb += String.join(", ", getData().getVariableNames());
        sb += "]";
        return sb;
    }

    @Override
    public Datatype<Scope> add(Datatype other) throws TunkkiError {
        return null;
    }

    @Override
    public Datatype<Scope> subtract(Datatype other) throws TunkkiError {
        return null;
    }

    @Override
    public Datatype<Scope> multiply(Datatype other) throws TunkkiError {
        return null;
    }

    @Override
    public Datatype<Scope> divide(Datatype other) throws TunkkiError {
        return null;
    }

    @Override
    public BooleanDatatype equals(Datatype other) throws TunkkiError {
        // TODO
        return new BooleanDatatype(false);
    }
}
