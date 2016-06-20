package com.jantuomi.interpreter.main.core.parser.datatype;

/**
 * Created by jan on 16.6.2016.
 */
public class StringDataContainer extends DataContainer<String> {
    private String value;

    public StringDataContainer(String text) {
        this.value = text;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public DataContainer<String> add(DataContainer<String> other) {
        return new StringDataContainer(
                value + ((StringDataContainer) other).value
        );
    }

    @Override
    public DataContainer<String> subtract(DataContainer<String> other) {
        return null;
    }
}
