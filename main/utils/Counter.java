package com.jantuomi.interpreter.main.utils;

/**
 * Created by jan on 13.6.2016.
 */
public class Counter {
    private int value = 0;

    public int getRecursionDepth() {
        return recursionDepth;
    }

    private int recursionDepth = 0;

    public int advance() {
        return ++value;
    }

    public int deeper() {
        return ++recursionDepth;
    }

    public int shallower() {
        return --recursionDepth;
    }

    public int getValue() {
        return value;
    }

    public void assign(Counter other) {
        value = other.value;
        recursionDepth = other.recursionDepth;
    }

    public Counter clone() {
        Counter c = new Counter();
        c.value = value;
        c.recursionDepth = recursionDepth;
        return c;
    }
}
