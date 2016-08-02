package com.jantuomi.tunkki.core.parser.datatype;

import com.jantuomi.tunkki.exception.types.TunkkiError;

/**
 * Created by jan on 16.6.2016.
 */
public class IntegerDatatype extends Datatype<Integer> {

    public IntegerDatatype(int value) {
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
    public BooleanDatatype equals(Datatype other) throws TunkkiError {
        switch (other.getType()) {
            case Integer:
                return new BooleanDatatype(getData().equals(other.getData()));
            case Double:
                return new BooleanDatatype(
                        new DoubleDatatype(getData()).equals(
                                ((DoubleDatatype) other).getData()));
            case Nada:
                return new BooleanDatatype(false);
        }
        return null;
    }

    @Override
    public Datatype add(Datatype other) {
        switch (other.getType()) {
            case Integer:
                return new IntegerDatatype(
                        this.getData() + ((IntegerDatatype) other).getData()
                );
            case Double:
                return new DoubleDatatype(
                        (double) getData() + ((DoubleDatatype) other).getData()
                );
            default:
                return null;

        }
    }

    @Override
    public Datatype subtract(Datatype other) {
        switch (other.getType()) {
            case Integer:
                return new IntegerDatatype(
                        this.getData() - ((IntegerDatatype) other).getData()
                );
            case Double:
                return new DoubleDatatype(
                        (double) getData() - ((DoubleDatatype) other).getData()
                );
            default:
                return null;

        }
    }

    @Override
    public Datatype multiply(Datatype other) throws TunkkiError {
        switch (other.getType()) {
            case Integer:
                return new IntegerDatatype(
                        this.getData() * ((IntegerDatatype) other).getData()
                );
            case Double:
                return new DoubleDatatype(
                        (double) getData() * ((DoubleDatatype) other).getData()
                );
            default:
                return null;

        }
    }

    @Override
    public Datatype divide(Datatype other) throws TunkkiError {
        switch (other.getType()) {
            case Integer:
                return new IntegerDatatype(
                        this.getData() / ((IntegerDatatype) other).getData()
                );
            case Double:
                return new DoubleDatatype(
                        (double) getData() / ((DoubleDatatype) other).getData()
                );
            default:
                return null;

        }
    }

    public DoubleDatatype asDouble() {
        return new DoubleDatatype(getData().doubleValue());
    }
}
