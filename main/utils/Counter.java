package com.jantuomi.interpreter.main.utils;

/**
 * Created by jan on 13.6.2016.
 */
public class Counter {
    private int value = 0;

    public int advance() {
        value = value + 1;
        return value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Counter clone() {
        Counter c = new Counter();
        c.value = value;
        return c;
    }
}
