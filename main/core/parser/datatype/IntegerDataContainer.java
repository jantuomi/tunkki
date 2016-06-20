package com.jantuomi.interpreter.main.core.parser.datatype;

/**
 * Created by jan on 16.6.2016.
 */
public class IntegerDataContainer extends DataContainer<Integer> {

    private int value;

    public IntegerDataContainer(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    @Override
    public DataContainer<Integer> add(DataContainer<Integer> other) {
        return new IntegerDataContainer(
                this.value + ((IntegerDataContainer) other).value
        );
    }

    @Override
    public DataContainer<Integer> subtract(DataContainer<Integer> other) {
        return new IntegerDataContainer(
                this.value - ((IntegerDataContainer) other).value
        );
    }
}
