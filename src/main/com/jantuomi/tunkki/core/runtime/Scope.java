package com.jantuomi.tunkki.core.runtime;

import com.jantuomi.tunkki.core.parser.datatype.DataContainer;
import com.jantuomi.tunkki.exception.BorkError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jan on 20.6.2016.
 */
public class Scope {
    private Scope parent = null;

    private Map<String, DataContainer> variables = new HashMap<>();
    private Map<String, Function> functions = new HashMap<>();

    public void addVariable(String symbol) {
        variables.put(symbol, null);
    }

    public void setVariableValue(String symbol, DataContainer value) {
        variables.replace(symbol, value);
    }

    public DataContainer resolveSymbol(String symbol, List<DataContainer> params) throws BorkError {
        if (functions.containsKey(symbol)) {
            DataContainer r = functions.get(symbol).evaluate(params);
            return r;
        }
        if (variables.containsKey(symbol)) {
            return variables.get(symbol);
        }
        else if (parent != null) {
            return parent.resolveSymbol(symbol, params);
        }
        else {
            return null;
        }
    }

    public void setParent(Scope parent) {
        this.parent = parent;
    }

    public void addFunction(String symbol, Function func) {
        functions.put(symbol, func);
    }
}
