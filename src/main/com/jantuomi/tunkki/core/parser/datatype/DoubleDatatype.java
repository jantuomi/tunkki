package com.jantuomi.tunkki.core.parser.datatype;

import com.jantuomi.tunkki.exception.TunkkiError;

/**
 * Created by jan on 22.6.2016.
 */
public class DoubleDatatype extends Datatype<Double> {
    public DoubleDatatype(double value) {
        setData(value);
    }

    @Override
    public Type getType() {
        return Type.Double;
    }

    @Override
    public String toString() {
        return getData().toString();
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
