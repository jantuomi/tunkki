package com.jantuomi.tunkki.core.parser.datatype;

import com.jantuomi.tunkki.core.runtime.Function;
import com.jantuomi.tunkki.exception.types.TunkkiError;

/**
 * Created by jan on 29.8.2016.
 */
public class ObjectPrototypeDatatype extends Datatype<Function> {
    @Override
    public Type getType() {
        return Type.ObjectPrototype;
    }

    @Override
    public String toString() {
        return "Object prototype";
    }

    public ObjectDatatype instantiate() {
        ObjectDatatype obj = new ObjectDatatype();
        obj.setData(getData().getState().getGlobalScope());
        return obj;
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
        return null;
    }
}
