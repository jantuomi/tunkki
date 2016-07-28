package com.jantuomi.tunkki.core.parser.datatype;

import com.jantuomi.tunkki.exception.TunkkiError;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jan on 27.7.2016.
 */
public class ListDataContainer extends DataContainer<List<DataContainer>> {

    public ListDataContainer(List<DataContainer> elements) {
        setData(elements);
    }

    @Override
    public Type getType() {
        return Type.List;
    }

    @Override
    public String toString() {
        return DataContainer.toString(getData());
    }

    @Override
    public DataContainer add(DataContainer other) throws TunkkiError {
        switch (other.getType()) {
            case List:
                List<DataContainer> newList = new ArrayList<>();
                newList.addAll(getData());
                newList.addAll(((ListDataContainer) other).getData());
                return new ListDataContainer(newList);
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
