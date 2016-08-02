package com.jantuomi.tunkki.core.parser.datatype;

import com.jantuomi.tunkki.exception.types.TunkkiError;

/**
 * Created by jan on 22.6.2016.
 */
public class DoubleDatatype extends Datatype<Double> {
    public DoubleDatatype(double value) {
        setData(value);
    }

    private final static double EPSILON = 0.00001;

    @Override
    public Type getType() {
        return Type.Double;
    }

    @Override
    public String toString() {
        return getData().toString();
    }

    @Override
    public BooleanDatatype equals(Datatype other) throws TunkkiError {
        switch (other.getType()) {
            case Integer:
                return new DoubleDatatype(((IntegerDatatype) other).getData()).equals(this);
            case Double:
                return new BooleanDatatype(
                    Math.abs(getData() - ((DoubleDatatype) other).getData()) < EPSILON
                );
            case Nada:
                return new BooleanDatatype(false);
        }
        return null;
    }

    @Override
    public Datatype add(Datatype other) throws TunkkiError {
        switch (other.getType()) {
            case Double:
                return new DoubleDatatype(
                        getData() + ((DoubleDatatype) other).getData()
                );
            case Integer:
                return new DoubleDatatype(
                        getData() + ((IntegerDatatype) other).getData()
                );
            default:
                return null;
        }
    }

    @Override
    public Datatype subtract(Datatype other) throws TunkkiError {
        switch (other.getType()) {
            case Double:
                return new DoubleDatatype(
                        getData() - ((DoubleDatatype) other).getData()
                );
            case Integer:
                return new DoubleDatatype(
                        getData() - ((IntegerDatatype) other).getData()
                );
            default:
                return null;
        }
    }

    @Override
    public Datatype multiply(Datatype other) throws TunkkiError {
        switch (other.getType()) {
            case Double:
                return new DoubleDatatype(
                        getData() * ((DoubleDatatype) other).getData()
                );
            case Integer:
                return new DoubleDatatype(
                        getData() * ((IntegerDatatype) other).getData()
                );
            default:
                return null;
        }
    }

    @Override
    public Datatype divide(Datatype other) throws TunkkiError {
        switch (other.getType()) {
            case Double:
                return new DoubleDatatype(
                        getData() / ((DoubleDatatype) other).getData()
                );
            case Integer:
                return new DoubleDatatype(
                        getData() / ((IntegerDatatype) other).getData()
                );
            default:
                return null;
        }
    }
}
