package com.jantuomi.interpreter.main.core.parser.datatype;

import com.jantuomi.interpreter.main.exception.InterpreterException;

/**
 * Created by jan on 22.6.2016.
 */
public class DoubleDataContainer extends DataContainer<Double> {
    public DoubleDataContainer(double value) {
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
    public DataContainer add(DataContainer other) throws InterpreterException {
        switch (other.getType()) {
            case Double:
                return new DoubleDataContainer(
                        getData() + ((DoubleDataContainer) other).getData()
                );
            case Integer:
                return new DoubleDataContainer(
                        getData() + ((IntegerDataContainer) other).getData()
                );
            default:
                return null;
        }
    }

    @Override
    public DataContainer subtract(DataContainer other) throws InterpreterException {
        switch (other.getType()) {
            case Double:
                return new DoubleDataContainer(
                        getData() - ((DoubleDataContainer) other).getData()
                );
            case Integer:
                return new DoubleDataContainer(
                        getData() - ((IntegerDataContainer) other).getData()
                );
            default:
                return null;
        }
    }

    @Override
    public DataContainer multiply(DataContainer other) throws InterpreterException {
        switch (other.getType()) {
            case Double:
                return new DoubleDataContainer(
                        getData() * ((DoubleDataContainer) other).getData()
                );
            case Integer:
                return new DoubleDataContainer(
                        getData() * ((IntegerDataContainer) other).getData()
                );
            default:
                return null;
        }
    }

    @Override
    public DataContainer divide(DataContainer other) throws InterpreterException {
        switch (other.getType()) {
            case Double:
                return new DoubleDataContainer(
                        getData() / ((DoubleDataContainer) other).getData()
                );
            case Integer:
                return new DoubleDataContainer(
                        getData() / ((IntegerDataContainer) other).getData()
                );
            default:
                return null;
        }
    }
}
