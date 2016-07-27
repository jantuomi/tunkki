package com.jantuomi.tunkki.core.parser.datatype;

import com.jantuomi.tunkki.exception.TunkkiError;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jan on 27.7.2016.
 */
public class ListDataContainer extends DataContainer{
    @Override
    public Type getType() {
        return Type.List;
    }

    private List<DataContainer> elements = new ArrayList<>();

    @Override
    public String toString() {
        List<String> strings = elements.stream().map( dataContainer -> dataContainer.toString() ).collect(Collectors.toList());
        return String.join(", ", strings);
    }

    @Override
    public DataContainer add(DataContainer other) throws TunkkiError {
        switch (other.getType()) {
            case List:
                elements.addAll(((ListDataContainer) other).elements);
                break;
        }
        return null;
    }

    @Override
    public DataContainer subtract(DataContainer other) throws TunkkiError {
        return null;
    }

    @Override
    public DataContainer multiply(DataContainer other) throws TunkkiError {
        return null;
    }

    @Override
    public DataContainer divide(DataContainer other) throws TunkkiError {
        return null;
    }
}
