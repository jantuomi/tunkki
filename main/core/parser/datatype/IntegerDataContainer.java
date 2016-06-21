package com.jantuomi.interpreter.main.core.parser.datatype;

/**
 * Created by jan on 16.6.2016.
 */
public class IntegerDataContainer extends DataContainer<Integer> {

    public IntegerDataContainer(int value) {
        setData(value);
    }

    @Override
    public String toString() {
        return Integer.toString(getData());
    }

    @Override
    public DataContainer<Integer> add(DataContainer<Integer> other) {
        return new IntegerDataContainer(
                this.getData() + other.getData()
        );
    }

    @Override
    public DataContainer<Integer> subtract(DataContainer<Integer> other) {
        return new IntegerDataContainer(
                this.getData() - other.getData()
        );
    }
}
