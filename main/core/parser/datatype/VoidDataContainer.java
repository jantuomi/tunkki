package com.jantuomi.interpreter.main.core.parser.datatype;

/**
 * Created by jan on 17.6.2016.
 */
public class VoidDataContainer extends DataContainer<Integer> {

    @Override
    public String toString() {
        return "";
    }

    @Override
    public DataContainer<Integer> add(DataContainer<Integer> other) {
        return null;
    }

    @Override
    public DataContainer<Integer> subtract(DataContainer<Integer> other) {
        return null;
    }
}
