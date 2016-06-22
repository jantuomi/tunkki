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
    public DataContainer<Double> add(DataContainer<Double> other) throws InterpreterException {
        return new DoubleDataContainer(
                getData() + other.getData()
        );
    }

    @Override
    public DataContainer<Double> subtract(DataContainer<Double> other) throws InterpreterException {
        return new DoubleDataContainer(
                getData() - other.getData()
        );
    }

    @Override
    public DataContainer<Double> multiply(DataContainer<Double> other) throws InterpreterException {
        return new DoubleDataContainer(
                getData() * other.getData()
        );
    }

    @Override
    public DataContainer<Double> divide(DataContainer<Double> other) throws InterpreterException {
        return new DoubleDataContainer(
                getData() / other.getData()
        );
    }
}
