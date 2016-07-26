package com.jantuomi.tunkki.core.parser.datatype;

import com.jantuomi.tunkki.exception.BorkError;

/**
 * Created by jan on 16.6.2016.
 */
public class IntegerDataContainer extends DataContainer<Integer> {

    public IntegerDataContainer(int value) {
        setData(value);
    }

    @Override
    public Type getType() {
        return Type.Integer;
    }

    @Override
    public String toString() {
        return Integer.toString(getData());
    }

    @Override
    public DataContainer add(DataContainer other) {
        switch (other.getType()) {
            case Integer:
                return new IntegerDataContainer(
                        this.getData() + ((IntegerDataContainer) other).getData()
                );
            case Double:
                return new DoubleDataContainer(
                        (double) getData() + ((DoubleDataContainer) other).getData()
                );
            default:
                return null;

        }
    }

    @Override
    public DataContainer subtract(DataContainer other) {
        switch (other.getType()) {
            case Integer:
                return new IntegerDataContainer(
                        this.getData() - ((IntegerDataContainer) other).getData()
                );
            case Double:
                return new DoubleDataContainer(
                        (double) getData() - ((DoubleDataContainer) other).getData()
                );
            default:
                return null;

        }
    }

    @Override
    public DataContainer multiply(DataContainer other) throws BorkError {
        switch (other.getType()) {
            case Integer:
                return new IntegerDataContainer(
                        this.getData() * ((IntegerDataContainer) other).getData()
                );
            case Double:
                return new DoubleDataContainer(
                        (double) getData() * ((DoubleDataContainer) other).getData()
                );
            default:
                return null;

        }
    }

    @Override
    public DataContainer divide(DataContainer other) throws BorkError {
        switch (other.getType()) {
            case Integer:
                return new IntegerDataContainer(
                        this.getData() / ((IntegerDataContainer) other).getData()
                );
            case Double:
                return new DoubleDataContainer(
                        (double) getData() / ((DoubleDataContainer) other).getData()
                );
            default:
                return null;

        }
    }
}
