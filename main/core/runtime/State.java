package com.jantuomi.interpreter.main.core.runtime;

import com.jantuomi.interpreter.main.core.parser.datatype.DataContainer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jan on 11.6.2016.
 */
public class State {
    private static final State instance = new State();

    public static State getInstance() {
        return instance;
    }

    private Map<String, DataContainer> variables = new HashMap<>();

    private State() {

    }

    public DataContainer getSymbolValue(String symbol) {
        if (variables.keySet().contains(symbol)) {
            return variables.get(symbol);
        } else {
            return null;
        }
    }

    public void setSymbolValue(String symbol, DataContainer value) {
        variables.put(symbol, value);
    }
}
