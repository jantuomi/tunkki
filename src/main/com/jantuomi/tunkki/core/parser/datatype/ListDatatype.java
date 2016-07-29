package com.jantuomi.tunkki.core.parser.datatype;

import com.jantuomi.tunkki.exception.TunkkiError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jan on 27.7.2016.
 */
public class ListDatatype extends Datatype<List<Datatype>> {

    public ListDatatype(List<Datatype> elements) {
        setData(elements);
    }

    @Override
    public Type getType() {
        return Type.List;
    }

    @Override
    public String toString() {
        return Datatype.toString(getData());
    }

    @Override
    public Datatype add(Datatype other) throws TunkkiError {
        switch (other.getType()) {
            case List:
                List<Datatype> newList = new ArrayList<>();
                newList.addAll(getData());
                newList.addAll(((ListDatatype) other).getData());
                return new ListDatatype(newList);
        }
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
}
